package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
class Problem128 {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var result = 1
        numSet.filter { num -> num - 1 !in numSet }.forEach { num ->
            var current = num + 1
            while (current in numSet) current++
            result = max(result, current - num)
        }
        return result
    }
}
