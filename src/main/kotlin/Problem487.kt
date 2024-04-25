import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/max-consecutive-ones-ii/solutions/5008489/follow-up-linear-solution-without-additional-lineinoe-reshenie-bez-dopolnitelnoi-pamiati/
 */
class Problem487 {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var current = 0
        var prev = -1
        nums.forEach { num ->
            if (num == 1) {
                current++
                result = max(result, current + prev + 1)
            } else {
                prev = current
                result = max(result, prev + 1)
                current = 0
            }
        }
        return result
    }
}

fun main() {
    val problem = Problem487()
    check(8 == problem.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0, 1, 1, 1, 1)))
    check(4 == problem.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0)))
    check(3 == problem.findMaxConsecutiveOnes(intArrayOf(1, 1, 1)))
    check(1 == problem.findMaxConsecutiveOnes(intArrayOf(0, 0, 0, 0)))
}
