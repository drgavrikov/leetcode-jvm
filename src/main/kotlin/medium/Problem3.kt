package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/3742832/sliding-window-linear-solution/
 */
class Problem3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastCharIndex = HashMap<Char, Int>()
        var result = 0

        var left = 0
        s.forEachIndexed { right, char ->
            left = max(left, lastCharIndex.getOrDefault(char, -1) + 1)
            result = max(result,right - left + 1)
            lastCharIndex[char] = right
        }
        return result
    }
}

fun main() {
    val problem = Problem3()

    runDynamicTest("test1") {
        val actual = problem.lengthOfLongestSubstring("abcabcbb")
        check(actual == 3) { "Test failed: Expected 3, actual: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem.lengthOfLongestSubstring("bbbbb")
        check(actual == 1) { "Test failed: Expected 1, actual: $actual" }
    }
}
