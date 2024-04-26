import kotlin.math.abs
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-ideal-subsequence/
 */
class Problem2370 {
    fun longestIdealString(s: String, k: Int): Int {
        val dp = IntArray(26) { 0 }
        s.forEach { char ->
            val index = char - 'a'
            var result = 0
            for (prev in 0 until 26) {
                if (abs(prev - index) <= k)
                    result = max(result, dp[prev])
            }
            dp[index] = result + 1
        }
        return dp.maxOf { it }
    }
}

fun main() {
    val problem = Problem2370()

    val actual1 = problem.longestIdealString("acfgbd", 2)
    check(actual1 == 4) { "Test failed: Expected 4, actual: $actual1" }

    val actual2 = problem.longestIdealString("abcd", 3)
    check(actual1 == 4) { "Test failed: Expected 4, actual: $actual2" }
}
