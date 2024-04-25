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

fun main() {
    val problem = Problem53()

    runDynamicTest("test1") {
        val actual = problem.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
        check(actual == 6) { "Test 1 failed: Expected 6, but got $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem.maxSubArray(intArrayOf(5, 4, -1, 7, 8))
        check(actual == 23) { "Test 2 failed: Expected 23, but got $actual" }
    }
}
