import java.util.*
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solutions/5357132/sliding-window-and-multiset/
 */
class Problem1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val multiset = TreeMap<Int, Int>()
        var result = 0

        var left = 0
        for (right in nums.indices) {
            val numRight = nums[right]
            multiset[numRight] = multiset.getOrDefault(numRight, 0) + 1

            while (multiset.lastKey() - multiset.firstKey() > limit) {
                val numLeft = nums[left]
                multiset[numLeft] = multiset.getValue(numLeft) - 1
                if (multiset.getValue(numLeft) == 0) multiset.remove(numLeft)
                left++
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

