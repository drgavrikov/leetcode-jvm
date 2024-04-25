import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
class Problem128 {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var result = 1
        numSet.filter { num -> num - 1 !in numSet }.forEach { num ->
            var current = num + 1
            while (current in numSet) current++
            result = max(result, current - num)
        }
        return result
    }
}

fun main() {
    val problem = Problem128()

    val actual1 = problem.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))
    check(actual1 == 9) { "Test 1 failed: Expected 9, but got $actual1" }

    val actual2 = problem.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))
    check(actual2 == 4) { "Test 2 failed: Expected 4, but got $actual2" }
}
