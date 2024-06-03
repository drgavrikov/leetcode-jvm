/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/solutions/5254944/two-pointer-solution/
 */
class Problem2486 {
    fun appendCharacters(s: String, t: String): Int {
        var sIndex = 0
        var tIndex = 0
        while (sIndex < s.length && tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) ++tIndex
            ++sIndex
        }
        return t.length - tIndex
    }
}

fun main() {
    val problem = Problem2486()
    assert(problem.appendCharacters("coaching", "coding") == 4)
}
