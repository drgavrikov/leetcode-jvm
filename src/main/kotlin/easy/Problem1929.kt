package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/concatenation-of-array/
 */
class Problem1929 {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2)
        for (i in nums.indices) {
            result[i] = nums[i]
            result[i + nums.size] = nums[i]
        }
        return result
    }
}
