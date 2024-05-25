/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-score-words-formed-by-letters/solutions/5205505/brute-force-iterative-loop-for-every-subset/
 */
class Problem1255 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val letterCount = IntArray(ALPHABET_SIZE) { 0 }
        letters.map { letter -> letterCount[letter - 'a']++ }

        val n = words.size
        return (1 until (1 shl n)).maxOf { bitmask ->
            val currentLetterCount = IntArray(ALPHABET_SIZE) { 0 }
            (0 until n)
                .filter { bitmask and (1 shl it) != 0 }
                .map { words[it].forEach { letter -> currentLetterCount[letter - 'a']++ } }

            val take = (0 until ALPHABET_SIZE).all { index -> currentLetterCount[index] <= letterCount[index] }
            if (take) currentLetterCount.indices.sumOf { index -> currentLetterCount[index] * score[index] }
            else 0
        }
    }

    companion object {
        const val ALPHABET_SIZE: Int = 26
    }
}

fun main() {
    val problem1255 = Problem1255()

    val actual1 = problem1255.maxScoreWords(
        arrayOf("dog", "cat", "dad", "good"),
        charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
        intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    )
    check(actual1 == 23) { "Test failed: Expected 23, actual: $actual1" }

    val actual2 = problem1255.maxScoreWords(
        arrayOf("leetcode"),
        charArrayOf('l', 'e', 't', 'c', 'o', 'd'),
        intArrayOf(0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
    )
    check(actual2 == 0) { "Test failed: Expected 0, actual: $actual2" }
}

