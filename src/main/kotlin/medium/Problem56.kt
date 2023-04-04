package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/merge-intervals/
 */
class Problem56 {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy { it[0] })

        val result = mutableListOf(intervals.first())
        intervals.drop(1).forEach { interval ->
            val last = result.last()
            if (last[1] < interval[0]) result.add(interval)
            else last[1] = max(interval[1], last[1])
        }
        return result.toTypedArray()
    }
}
