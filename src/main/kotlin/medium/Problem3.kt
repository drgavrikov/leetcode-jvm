package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Problem3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var result = 1

        val chars = mutableSetOf<Char>()
        while (right < s.length) {
            while (chars.contains(s[right])) {
                chars.remove(s[left])
                left++
            }
            chars.add(s[right])
            result = max(right - left + 1, result)
            right++
        }
        return result
    }
}
