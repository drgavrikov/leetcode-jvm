package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-string-chain/
 */
class Problem1048 {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        val longestChain = words.map { 1 }.toIntArray()
        for (index in words.indices) {
            for (pred in 0 until index) {
                if (isPredecessor(words[pred], words[index])) {
                    longestChain[index] = max(longestChain[index], longestChain[pred] + 1)
                }
            }
        }
        return longestChain.max()!!
    }

    private fun isPredecessor(word1: String, word2: String): Boolean {
        if (word1.length != word2.length - 1) return false
        var index1 = 0
        var index2 = 0
        var insert = false
        while (index1 < word1.length && index2 < word2.length) {
            if (word1[index1] == word2[index2]) {
                index1++
                index2++
            } else {
                if (insert) return false
                index2++
                insert = true
            }
        }
        return true
    }
}
