import java.util.*
import kotlin.math.pow

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/accounts-merge/
 */
class Problem752 {

    private fun numberToArray(value: Int): IntArray {
        return (0..3)
            .map { index -> (value / 10.0.pow(index)).toInt() % 10 }
            .reversed()
            .toIntArray()
    }

    private fun arrayToNumber(intArray: IntArray) = intArray.fold(0) { acc, digit -> acc * 10 + digit }

    fun openLock(deadends: Array<String>, target: String): Int {
        val distanse = IntArray(10000) { 0 }
        deadends.forEach { deadend -> distanse[deadend.toInt()] = -1 }

        val queue = ArrayDeque<Int>()
        if (distanse[0] == 0) queue.add(0)
        while (queue.isNotEmpty()) {
            val peek = queue.removeFirst()
            if (peek == target.toInt()) return distanse[peek]

            for (index in 0..3) {
                intArrayOf(-1, 1).forEach { delta ->
                    val intArray = numberToArray(peek)
                    intArray[index] = ((intArray[index] + delta) + 10) % 10
                    val next = arrayToNumber(intArray)
                    if (distanse[next] == 0) {
                        queue.add(next)
                        distanse[next] = distanse[peek] + 1
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    val problem = Problem752()
    check(problem.openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202") == 6)
    check(problem.openLock(arrayOf("8888"), "0009") == 1)
}
