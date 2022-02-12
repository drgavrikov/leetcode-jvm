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
