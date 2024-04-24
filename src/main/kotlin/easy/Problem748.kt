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

fun main() {
    val problem748 = Problem748()

    runDynamicTest("test1") {
        val actual = problem748.shortestCompletingWord("1s3 PSt", arrayOf("step", "steps", "stripe", "stepple"))
        check(actual == "steps") { "Test failed: Expected 'steps', actual: '$actual'" }
    }

    runDynamicTest("test2") {
        val actual = problem748.shortestCompletingWord("1s3 456", arrayOf("looks", "pest", "stew", "show"))
        check(actual == "pest") { "Test failed: Expected 'pest', actual: '$actual'" }
    }
}

