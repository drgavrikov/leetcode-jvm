/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/word-pattern-ii/solutions/5221850/backtracking-solution/
 */
class Problem291 {
    fun wordPatternMatch(pattern: String, s: String): Boolean {

        val mapping = mutableMapOf<Char, String>()

        fun isMatch(patternIndex: Int = 0, strIndex: Int = 0): Boolean {
            if (patternIndex == pattern.length) return strIndex == s.length
            val currentChar = pattern[patternIndex]

            return if (currentChar in mapping) {
                val mappedString = mapping.getValue(currentChar)
                if (s.startsWith(mappedString, strIndex))
                    isMatch(patternIndex + 1, strIndex + mappedString.length)
                else false
            } else {
                val newMapping = StringBuilder()
                (strIndex until s.length).any { index ->
                    newMapping.append(s[index])
                    val candidate = newMapping.toString()
                    if (candidate !in mapping.values) {
                        mapping[currentChar] = candidate
                        val matchFound = isMatch(patternIndex + 1, index + 1)
                        mapping.remove(currentChar)
                        matchFound
                    } else false
                }
            }
        }

        return isMatch()
    }

    private fun String.startsWith(prefix: String, startIndex: Int): Boolean {
        if (startIndex + prefix.length > this.length) return false
        return prefix.indices.all { index -> this[startIndex + index] == prefix[index] }
    }
}

fun main() {
    val problem = Problem291()
    check(problem.wordPatternMatch("abab", "redblueredblue"))
    check(problem.wordPatternMatch("aaaa", "asdasdasdasd"))
    check(!problem.wordPatternMatch("aabb", "xyzabcxzyabc"))
}
