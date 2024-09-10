import java.util.PriorityQueue

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/k-th-smallest-prime-fraction/solutions/5767952/heap-priority-queue-solution/
 */
class Problem786 {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {

        data class Fraction(val numeratorIndex: Int, val denominatorIndex: Int) : Comparable<Fraction> {
            override fun compareTo(other: Fraction): Int {
                return arr[numeratorIndex] * arr[denominatorIndex] - arr[other.numeratorIndex] * arr[other.denominatorIndex]
            }
        }

        val queue = PriorityQueue<Fraction>()
        (0 until arr.size - 1).forEach { numIndex ->
            queue.add(Fraction(numIndex, arr.size - 1))
        }

        repeat(k - 1) {
            val top = queue.poll()
            queue.add(Fraction(top.numeratorIndex, top.denominatorIndex - 1))
        }
        val result = queue.peek()
        return intArrayOf(arr[result.numeratorIndex], arr[result.denominatorIndex])
    }
}

fun main() {
    val problem = Problem786()
    assert(problem.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3).contentEquals(intArrayOf(2, 5)))
}
