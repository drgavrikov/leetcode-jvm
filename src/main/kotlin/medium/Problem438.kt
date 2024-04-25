package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
class Problem438 {

    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) return emptyList()

        val pCount = p.groupingBy { it }.eachCount()
        val sCount = (0..p.length - 2)
            .map { index -> s[index] }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        val result = mutableListOf<Int>()
        for (index in p.length - 1 until s.length) {
            sCount[s[index]] = sCount.getOrDefault(s[index], 0) + 1
            if (index - p.length >= 0) {
                val removeChar = s[index - p.length]
                sCount[removeChar] = sCount.getOrDefault(removeChar, 0) - 1
                if (sCount[removeChar] == 0) sCount.remove(removeChar)
            }
            if (sCount == pCount) result.add(index - p.length + 1)
        }
        return result
    }
}

fun main() {
    val problem438 = Problem438()
    check(problem438.findAnagrams("cbaebabacd", "abc") == listOf(0, 6))
    check(problem438.findAnagrams("abab", "ab") == listOf(0, 1, 2))
}
