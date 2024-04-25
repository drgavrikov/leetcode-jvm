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

fun main() {
    val problem53 = Problem53()

    val actual1 = problem53.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    check(actual1 == 6) { "Test failed: Expected 6, actual: $actual1" }

    val actual2 = problem53.maxSubArray(intArrayOf(5, 4, -1, 7, 8))
    check(actual2 == 23) { "Test failed: Expected 23, actual: $actual2" }
}
