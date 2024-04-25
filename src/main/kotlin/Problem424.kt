import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-repeating-character-replacement/
 */
class Problem424 {

    fun characterReplacement(s: String, k: Int): Int {
        val charsCount = mutableMapOf<Char, Int>()
        var left = 0
        var result = 0
        s.indices.forEach { rigth ->
            val char = s[rigth]
            charsCount.set(char, charsCount.getOrDefault(char, 0) + 1)
            val maxFrequency = charsCount.values.maxOrNull()!!

            if (rigth - left + 1 - maxFrequency > k) {
                charsCount[s[left]] = charsCount.getOrDefault(s[left], 0) - 1
                left++
            }
            result = max(result, rigth - left + 1)
        }
        return result
    }
}

fun main() {
    val problem = Problem424()
    val actual = problem.characterReplacement("AABABBA", 1)
    check(actual == 4)
}
