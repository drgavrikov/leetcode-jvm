package easy

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/max-consecutive-ones/
 */
class Problem485 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var current = 0
        nums.forEach { num ->
            if (num == 0) {
                result = max(result, current)
                current = 0
            } else current += 1
        }
        return max(result, current)
    }
}
