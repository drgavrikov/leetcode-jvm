package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
class Problem1313 {
    fun decompressRLElist(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (i in nums.indices step 2) {
            val freq = nums[i]
            val value = nums[i + 1]
            result.addAll((0 until freq).map { value }.toList())
        }
        return result.toIntArray()
    }
}
