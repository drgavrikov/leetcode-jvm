package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/permutation-in-string/
 */
class Problem567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1CharCounts = s1.groupingBy { it }.eachCount()
        val s2CharCounts = mutableMapOf<Char, Int>()

        s1.indices.forEach { index ->
            val char = s2[index]
            s2CharCounts[char] = s2CharCounts.getOrDefault(char, 0) + 1
        }

        if (s1CharCounts == s2CharCounts) return true
        for (index in s1.length until s2.length) {
            val newChar = s2[index]
            s2CharCounts[newChar] = s2CharCounts.getOrDefault(newChar, 0) + 1

            val oldChar = s2[index - s1.length]
            s2CharCounts[oldChar] = s2CharCounts.getOrDefault(oldChar, 0) - 1
            if (s2CharCounts[oldChar] == 0) s2CharCounts.remove(oldChar)

            if (s1CharCounts == s2CharCounts) return true
        }
        return false
    }
}

fun main() {
    val problem = Problem567()
    val actual = problem.checkInclusion("ab", "eidbaooo")
    check(actual)
}
