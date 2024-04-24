package hard


/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/regular-expression-matching/
 */
class Problem10 {

    data class Indices(val stringIndex: Int, val patternIndex: Int) : Comparable<Indices> {
        override fun compareTo(other: Indices): Int {
            return if (stringIndex == other.stringIndex) patternIndex.compareTo(other.patternIndex)
            else stringIndex.compareTo(other.stringIndex)
        }
    }

    fun isMatch(s: String, p: String): Boolean {

        val queue = sortedSetOf(Indices(0, 0))

        while (queue.isNotEmpty()) {
            val (stringIndex, patternIndex) = queue.pollFirst()!!
            if (patternIndex == p.length && stringIndex == s.length) return true
            val charMatch = stringIndex < s.length && patternIndex < p.length &&
                    (s[stringIndex] == p[patternIndex] || p[patternIndex] == '.')
            if (patternIndex + 1 < p.length && p[patternIndex + 1] == '*') {
                if (charMatch) queue.add(Indices(stringIndex + 1, patternIndex))
                queue.add(Indices(stringIndex, patternIndex + 2))
            } else if (charMatch)
                queue.add(Indices(stringIndex + 1, patternIndex + 1))
        }
        return false
    }
}

fun main() {
    val problem10 = Problem10()

    runDynamicTest("test1") {
        check(!problem10.isMatch("ab", ".*c")) { "Test failed: 'ab' does not match '.*c'" }
        check(problem10.isMatch("aa", "a.")) { "Test failed: 'aa' matches 'a.'" }
        check(problem10.isMatch("aa", "a*")) { "Test failed: 'aa' matches 'a*'" }
        check(!problem10.isMatch("aa", "a")) { "Test failed: 'aa' does not match 'a'" }
        check(problem10.isMatch("aab", "c*a*b")) { "Test failed: 'aab' matches 'c*a*b'" }
        check(!problem10.isMatch("mississippi", "mis*is*p*.")) { "Test failed: 'mississippi' does not match 'mis*is*p*.'" }
    }
}
