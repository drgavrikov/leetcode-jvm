package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/shortest-completing-word/
 */
class Problem748 {

    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        return words.sortedBy { it.length }.first { word ->
            val plateCount = getLetterCount(licensePlate)
            val wordCount = getLetterCount(word)
            plateCount.all { (char, int) -> int <= wordCount.getOrDefault(char, 0) }
        }
    }

    private fun getLetterCount(word: String) = word.filter { it.isLetter() }
        .groupingBy { it.lowercaseChar() }
        .eachCount()
}
