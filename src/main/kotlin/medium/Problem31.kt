package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/next-permutation/
 */
class Problem31 {

    fun nextPermutation(nums: IntArray) {

        val i = (0..nums.size - 2).lastOrNull { index -> nums[index] < nums[index + 1] } ?: -1
        if (i == -1) {
            nums.indices.forEach { index -> nums[index] = index + 1 }
            return
        }
        val j = (i + 1 until nums.size)
            .filter { index -> nums[index] > nums[i] }
            .minByOrNull { index -> nums[index] }!!

        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

        nums.reverse(i + 1, nums.size)
    }
}

fun main() {
    val problem = Problem31()

    runDynamicTest("test1") {
        val nums = intArrayOf(1, 2, 3)
        problem.nextPermutation(nums)
        check(nums contentEquals intArrayOf(1, 3, 2)) { "Test 1 failed: Expected [1, 3, 2], but got: ${nums.contentToString()}" }
    }

    runDynamicTest("test2") {
        val nums = intArrayOf(3, 2, 1)
        problem.nextPermutation(nums)
        check(nums contentEquals intArrayOf(1, 2, 3)) { "Test 2 failed: Expected [1, 2, 3], but got: ${nums.contentToString()}" }
    }
}
