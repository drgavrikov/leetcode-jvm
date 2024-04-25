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

fun main() {
    val problem1480 = Problem1480()

    runDynamicTest("test1") {
        val actual = problem1480.runningSum(intArrayOf(1, 2, 3, 4))
        check(actual.contentEquals(intArrayOf(1, 3, 6, 10))) { "Test failed: Expected [1, 3, 6, 10], actual: ${actual.contentToString()}" }
    }

    runDynamicTest("test2") {
        val actual = problem1480.runningSum(intArrayOf(1, 1, 1, 1, 1))
        check(actual.contentEquals(intArrayOf(1, 2, 3, 4, 5))) { "Test failed: Expected [1, 2, 3, 4, 5], actual: ${actual.contentToString()}" }
    }

    runDynamicTest("test3") {
        val actual = problem1480.runningSum(intArrayOf(1, 2, 3))
        check(actual.contentEquals(intArrayOf(1, 3, 6))) { "Test failed: Expected [1, 3, 6], actual: ${actual.contentToString()}" }
    }
}
