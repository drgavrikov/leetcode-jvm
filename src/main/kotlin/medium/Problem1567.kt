package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 */
class Problem1567 {

    fun getMaxLen(nums: IntArray): Int {
        val list = nums.toList()
        var result = 0
        var first = 0
        while (first < list.size && list[first] == 0) first++
        while (first < list.size) {
            var last = first
            while (last < list.size && list[last] != 0) last++
            result = max(result, getMaxLenWithoutZero(list.subList(first, last)))
            first = last
            while (first < list.size && list[first] == 0) first++
        }
        return result
    }

    private fun getMaxLenWithoutZero(nums: List<Int>): Int {
        val negativeCount = nums.count { it < 0 }
        if (negativeCount % 2 == 0) return nums.size
        val firstNegativeIndex = nums.indexOfFirst { it < 0 }
        val lastNegativeIndex = nums.indexOfLast { it < 0 }
        return max(nums.size - firstNegativeIndex - 1, lastNegativeIndex)
    }
}
