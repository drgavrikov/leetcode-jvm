import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/solutions/5035977/greedy-linear-solution-without-additional-memory/
 */
class Problem1493 {
    fun longestSubarray(nums: IntArray): Int {

        var result = 0

        var count = 0
        var countPrev = 0

        var isZeros = false

        for (element in nums) {
            if (element == 1) {
                count++
                result = max(countPrev + count, result)
            } else {
                countPrev = count
                count = 0
                isZeros = true
            }
        }
        if (!isZeros) return nums.size - 1
        return result
    }
}

fun main() {
    val problem1493 = Problem1493()
    check(5 == problem1493.longestSubarray(intArrayOf(1, 1, 1, 0, 1, 1)))
    check(3 == problem1493.longestSubarray(intArrayOf(1, 1, 1, 0)))
    check(3 == problem1493.longestSubarray(intArrayOf(1, 1, 1, 1)))
}
