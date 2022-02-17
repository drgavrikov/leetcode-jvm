package easy

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-subarray
 */
class Problem53 {
    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var sum = 0

        nums.forEach { value ->
            sum += value
            result = max(result, sum)
            sum = max(0, sum)
        }
        return result
    }
}
