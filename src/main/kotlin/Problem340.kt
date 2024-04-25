import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
class Problem340 {

    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        if (k == 0) return 0

        var result = 0
        val counts = HashMap<Char, Int>()

        var lf = 0
        var rt = 0

        var current = 0
        while (rt < s.length && current <= k) {
            val char = s[rt]
            if (!counts.containsKey(char) || counts[char] == 0) current++
            counts[char] = counts.getOrDefault(char, 0) + 1

            while (lf <= rt && current > k) {
                counts[s[lf]] = counts.getValue(s[lf]) - 1
                if (counts[s[lf]] == 0) current--
                lf++
            }

            result = max(result, rt - lf + 1)

            rt++
        }
        return result
    }
}

fun main() {
    val problem = Problem340()
    check(problem.lengthOfLongestSubstringKDistinct("eceba", 2) == 3)
    check(problem.lengthOfLongestSubstringKDistinct("eceba", 0) == 0)
    check(problem.lengthOfLongestSubstringKDistinct("aaaaaa", 1) == 6)
}
