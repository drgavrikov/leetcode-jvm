/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
class Problem153 {
    fun findMin(nums: IntArray): Int {
        if (nums.first() < nums.last()) return nums.first()
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] > nums[right]) left = mid + 1
            else right = mid
        }

        return nums[left]
    }
}

fun main() {
    val problem153 = Problem153()
    val actual = problem153.findMin(nums = intArrayOf(3, 4, 5, 1, 2))
    check(actual == 1)
}
