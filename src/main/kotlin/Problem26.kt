/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class Problem26 {
    fun removeDuplicates(nums: IntArray): Int {
        val empty = -1000
        var distinctIndex = 0
        for (index in 1 until nums.size) {
            if (nums[distinctIndex] != nums[index]) {
                distinctIndex++
                nums[distinctIndex] = nums[index]
                if (distinctIndex != index) nums[index] = empty
            } else nums[index] = empty
        }
        return distinctIndex + 1
    }
}

fun main() {
    val problem26 = Problem26()

    val actual1 = problem26.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
    check(actual1 == 5) { "Test failed: Expected 5, actual: $actual1" }

    val actual2 = problem26.removeDuplicates(intArrayOf(1, 2))
    check(actual2 == 2) { "Test failed: Expected 2, actual: $actual2" }
}
