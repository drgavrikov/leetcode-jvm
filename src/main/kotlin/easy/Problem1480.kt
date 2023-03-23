package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/running-sum-of-1d-array/
 */

class Problem1480 {
    fun runningSum(nums: IntArray): IntArray {
        val result = IntArray(nums.size) {0}
        nums.indices.forEach { index ->
            result[index] = nums[index]
            if (index > 0) result[index] += result[index - 1]
        }
        return result
    }
}
