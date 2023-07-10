package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-subarray
 */
class Problem53 {

    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var sum = 0
        nums.forEach { num ->
            sum += num
            if (maxSum < sum) maxSum = sum
            if (sum < 0) sum = 0
        }
        return maxSum
    }
}
