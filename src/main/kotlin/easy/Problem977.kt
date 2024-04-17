package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/squares-of-a-sorted-array/solutions/5036096/linear-solution-with-two-pointers/
 */
class Problem977 {
    fun sortedSquares(nums: IntArray): IntArray {
        val size = nums.size

        var left = 0
        var right = nums.size - 1
        val result = IntArray(size)

        var index = nums.size - 1
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                result[index] = nums[right] * nums[right]
                right--
            } else {
                result[index] = nums[left] * nums[left]
                left++
            }
            index--
        }
        return result
    }
}

fun main() {
    val problem = Problem977()
    val actual = problem.sortedSquares(intArrayOf(-4, -1, 0, 3, 10))
    check(actual.contentEquals(intArrayOf(0, 1, 9, 16, 100)))
}
