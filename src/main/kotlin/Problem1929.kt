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

fun main() {
    val problem1929 = Problem1929()

    runDynamicTest("test1") {
        val actual = problem1929.getConcatenation(intArrayOf(1, 2, 1))
        check(actual.contentEquals(intArrayOf(1, 2, 1, 1, 2, 1))) { "Test failed: Expected [1, 2, 1, 1, 2, 1], actual: ${actual.contentToString()}" }
    }
}
