package medium

import kotlin.math.max
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/interval-list-intersections/description/
 */
class Problem986 {

    private fun intersect(first: IntArray, second: IntArray): IntArray {
        val left = max(first[0], second[0])
        val right = min(first[1], second[1])
        return if (left <= right) intArrayOf(left, right) else intArrayOf()
    }

    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        return firstList
            .flatMap { first ->
                var left = 0
                var right = secondList.size - 1
                while (left < right) {
                    val middle = (left + right) / 2
                    if (secondList[middle][1] < first[0]) left = middle + 1
                    else right = middle
                }
                val result = mutableListOf<IntArray>()
                var index = left
                while (index < secondList.size && secondList[index][0] <= first[1]) {
                    val intersection = intersect(first, secondList[index])
                    if (intersection.isNotEmpty()) result.add(intersection)
                    index++
                }
                result
            }
            .toTypedArray()
    }
}

fun main() {
    val problem = Problem986()
    val firstList = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(5, 10),
        intArrayOf(13, 23),
        intArrayOf(24, 25)
    )
    val secondList = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(8, 12),
        intArrayOf(15, 24),
        intArrayOf(25, 26)
    )
    val intersection = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(5, 5),
        intArrayOf(8, 10),
        intArrayOf(15, 23),
        intArrayOf(24, 24),
        intArrayOf(25, 25)
    )
    val actual = problem.intervalIntersection(firstList, secondList)
    check(intersection.size == actual.size)
    actual.zip(intersection).forEach { (first, second) -> check(first.contentEquals(second)) }
}
