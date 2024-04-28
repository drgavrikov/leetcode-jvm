/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-ideal-subsequence/solutions/5083170/dynamic-programming-with-linear-complexity-beats-90-0-of-users-with-c/
 */
class Problem2370 {
    fun longestIdealString(s: String, k: Int): Int {
        val dp = IntArray(26) { 0 }
        s.forEach { char ->
            val index = char - 'a'
            var maxLength = 0
            for (shift in 0..k) {
                if (char - shift in 'a'..'z' && maxLength < dp[char - shift - 'a'] + 1) {
                    maxLength = dp[char - shift - 'a'] + 1
                }
                if (char + shift in 'a'..'z' && maxLength < dp[char + shift - 'a'] + 1) {
                    maxLength = dp[char + shift - 'a'] + 1
                }
            }
            dp[index] = maxLength
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
