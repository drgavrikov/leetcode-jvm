package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/product-of-array-except-self/
 */
class Problem238 {

    fun productExceptSelf(nums: IntArray): IntArray {
        val prefix = nums.copyOf()
        (1 until prefix.size).forEach { index -> prefix[index] *= prefix[index - 1] }

        val suffix = nums.copyOf()
        (suffix.size - 2 downTo  0).forEach { index -> suffix[index] *= suffix[index + 1] }

        nums[0] = suffix[1]
        (1 until nums.size - 1).forEach { index -> nums[index] = prefix[index - 1] * suffix[index + 1] }
        nums[nums.size - 1] = prefix[nums.size - 2]
        return nums
    }
}
