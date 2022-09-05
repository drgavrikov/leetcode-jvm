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
