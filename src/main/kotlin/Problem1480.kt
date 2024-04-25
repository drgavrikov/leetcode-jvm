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

    val actual1 = problem1480.runningSum(intArrayOf(1, 2, 3, 4))
    check(actual1.contentEquals(intArrayOf(1, 3, 6, 10))) { "Test failed: Expected [1, 3, 6, 10], actual: ${actual1.contentToString()}" }

    val actual2 = problem1480.runningSum(intArrayOf(1, 1, 1, 1, 1))
    check(actual2.contentEquals(intArrayOf(1, 2, 3, 4, 5))) { "Test failed: Expected [1, 2, 3, 4, 5], actual: ${actual2.contentToString()}" }

    val actual3 = problem1480.runningSum(intArrayOf(1, 2, 3))
    check(actual3.contentEquals(intArrayOf(1, 3, 6))) { "Test failed: Expected [1, 3, 6], actual: ${actual3.contentToString()}" }
}
