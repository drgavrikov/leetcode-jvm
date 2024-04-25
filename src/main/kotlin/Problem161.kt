import kotlin.math.abs

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/one-edit-distance/description/
 */

class Problem161 {
    fun isOneEditDistance(s: String, t: String): Boolean {
        if (abs(s.length - t.length) >= 2) return false
        var index = 0
        while (index < s.length && index < t.length && s[index] == t[index]) index++
        if (index == s.length && index == t.length) return false
        return isEquals(s, index, t, index + 1) || isEquals(s, index + 1, t, index) || isEquals(s, index + 1, t, index + 1)
    }

    private fun isEquals(s: String, sBegin: Int, t: String, tBegin: Int): Boolean {
        var sIndex = sBegin
        var tIndex = tBegin
        while (sIndex < s.length && tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) {
                sIndex++
                tIndex++
            } else return false
        }
        return sIndex >= s.length && tIndex >= t.length
    }
}

fun main() {
    val problem = Problem161()
    check(!problem.isOneEditDistance("asd", "asdfg"))
    check(problem.isOneEditDistance("ab", "abc"))
    check(problem.isOneEditDistance("abd", "ab"))
}