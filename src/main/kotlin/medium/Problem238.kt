package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/product-of-array-except-self/
 */
class Problem238 {

    fun productExceptSelf(nums: IntArray): IntArray {

        val suffix = nums.copyOf()
        (suffix.size - 2 downTo  0).forEach { index -> suffix[index] *= suffix[index + 1] }
        (1 until nums.size).forEach { index -> nums[index] *= nums[index - 1] }

        nums[nums.size - 1] = nums[nums.size - 2]
        (nums.size - 2 downTo 1).forEach { index ->
            nums[index] = nums[index - 1] * suffix[index + 1]
        }
        nums[0] = suffix[1]
        return nums
    }
}

fun main() {
    val problem = Problem238()

    val actual1 = problem.productExceptSelf(intArrayOf(1, 2, 3, 4))
    check(actual1.contentEquals(intArrayOf(24, 12, 8, 6))) { "Test 1 failed: Expected ${intArrayOf(24, 12, 8, 6)}, but got $actual1" }

    val actual2 = problem.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3))
    check(actual2.contentEquals(intArrayOf(0, 0, 9, 0, 0))) { "Test 2 failed: Expected ${intArrayOf(0, 0, 9, 0, 0)}, but got $actual2" }
}

