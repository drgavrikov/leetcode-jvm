import kotlin.collections.ArrayDeque
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solutions/5357132/sliding-window-solution/
 */
class Problem1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxDeque = ArrayDeque<Int>()
        val minDeque = ArrayDeque<Int>()
        var result = 0

        var left = 0
        for (right in nums.indices) {
            val numRight = nums[right]
            while (maxDeque.isNotEmpty() && maxDeque.last() < numRight) maxDeque.removeLast()
            maxDeque.addLast(numRight)

            while (minDeque.isNotEmpty() && minDeque.last() > numRight) minDeque.removeLast()
            minDeque.addLast(numRight)

            while (maxDeque.first() - minDeque.first() > limit) {
                val numLeft = nums[left++]
                if (maxDeque.first() == numLeft) maxDeque.removeFirst()
                if (minDeque.first() == numLeft) minDeque.removeFirst()
            }
            result = max(result, right - left + 1)
        }
        return result
    }
}

fun main() {
    val problem = Problem1438()

    check(problem.longestSubarray(intArrayOf(8, 2, 4, 7), 4) == 2)
    check(problem.longestSubarray(intArrayOf(10, 1, 2, 4, 7, 2), 5) == 4)
}
