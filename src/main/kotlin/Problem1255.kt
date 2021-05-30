import kotlin.math.max

class Problem1255 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        check(score.size == ALPHABET_SIZE)
        val remainingLetters = IntArray(ALPHABET_SIZE)
        letters.forEach { ch -> remainingLetters[ch - 'a']++ }
        val wordsScore = words.map { word -> wordScore(word, score) }.toList()
        return maxScore(words, 0, wordsScore, remainingLetters)
    }

    private fun maxScore(words: Array<String>, wordIndex: Int, wordsScore: List<Int>, remainingLetters: IntArray): Int {
        if (wordIndex == words.size) return 0
        val skipWordScore = maxScore(words, wordIndex + 1, wordsScore, remainingLetters)
        if (!isCollectWord(words[wordIndex], remainingLetters)) return skipWordScore
        words[wordIndex].forEach { ch -> remainingLetters[ch - 'a']-- }
        val addWordScore = maxScore(words, wordIndex + 1, wordsScore, remainingLetters) + wordsScore[wordIndex]
        words[wordIndex].forEach { ch -> remainingLetters[ch - 'a']++ }
        return max(addWordScore, skipWordScore)
    }

    private fun isCollectWord(word: String, count: IntArray): Boolean {
        val wordLetterCount = IntArray(ALPHABET_SIZE)
        word.forEach { ch -> wordLetterCount[ch - 'a']++ }
        return (0 until ALPHABET_SIZE).all { letterIndex -> wordLetterCount[letterIndex] <= count[letterIndex] }
    }

    private fun wordScore(word: String, score: IntArray) = word.map { ch -> score[ch - 'a'] }.sum()

    companion object {
        const val ALPHABET_SIZE: Int = 26
    }
}

fun main() {
    check(
        Problem1255().maxScoreWords(
            arrayOf("dog", "cat", "dad", "good"),
            charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
            intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        ) == 23
    )
}
