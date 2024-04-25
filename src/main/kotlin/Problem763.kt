import kotlin.math.max


/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/partition-labels/
 */
class Problem763 {
    fun partitionLabels(s: String): List<Int> {
        val maxCharIndex = s.mapIndexed { index, char -> char to index }.toMap()

        val result = mutableListOf<Int>()
        var index = 0
        while (index < s.length) {
            val left = index
            var right = maxCharIndex.getValue(s[index])
            while (index < right) {
                right = max(right, maxCharIndex.getValue(s[index]))
                index++
            }
            result.add(right - left + 1)
            index++
        }
        return result.toList()
    }
}

fun main() {
    val problem763 = Problem763()

    val actual1 = problem763.partitionLabels("ababcbacadefegdehijhklij")
    check(actual1 == listOf(9, 7, 8)) { "Test 1 failed" }

    val actual2 = problem763.partitionLabels("eccbbbbdec")
    check(actual2 == listOf(10)) { "Test 2 failed" }
}
