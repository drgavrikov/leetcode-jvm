import java.util.*
import kotlin.math.abs
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
class Problem1509 {
    fun minDifference(nums: IntArray): Int {
        val size = nums.size
        if (size <= 3) return 0
        Arrays.sort(nums)
        var result = abs(nums[size - 1] - nums[0])
        (0..3).forEach { index ->
            result = min(result, abs(nums[index] - nums[size - 4 + index]))
        }
        return result
    }
}

fun main() {
    val problem1509 = Problem1509()

    val actual1 = problem1509.minDifference(intArrayOf(5, 4, 2, 3))
    check(actual1 == 0) { "Test 1 failed" }

    val actual2 = problem1509.minDifference(intArrayOf(1, 5, 0, 10, 14))
    check(actual2 == 1) { "Test 2 failed" }

    val actual3 = problem1509.minDifference(intArrayOf(82, 81, 95, 75, 20))
    check(actual3 == 1) { "Test 3 failed" }
}
