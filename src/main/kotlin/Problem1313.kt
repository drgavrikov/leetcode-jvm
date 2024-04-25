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

fun main() {
    val problem1313 = Problem1313()

    val actual = problem1313.decompressRLElist(intArrayOf(1, 2, 3, 4))
    check(actual.contentEquals(intArrayOf(2, 4, 4, 4))) { "Test failed: Expected [2, 4, 4, 4], actual: ${actual.contentToString()}" }
}
