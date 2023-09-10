package medium

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
