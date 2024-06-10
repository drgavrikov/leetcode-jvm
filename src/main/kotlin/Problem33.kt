import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/5291996/double-binary-search-technique/
 */
class Problem33 {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.first() <= nums.last()) return max(-1, nums.binarySearch(target))
        var left = 1
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid - 1] > nums[mid]) {
                val result = max(
                    nums.binarySearch(element = target, fromIndex = 0, toIndex = mid),
                    nums.binarySearch(element = target, fromIndex = mid),
                )
                return max(result, -1)
            }
            if (nums[mid] > nums.last()) left = mid + 1
            else right = mid - 1
        }
        return -1
    }
}

fun main() {
    val problem = Problem33()
    check(problem.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0) == 4)
    check(problem.search(intArrayOf(1), 0) == -1)
}
