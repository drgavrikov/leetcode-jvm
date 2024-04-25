/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */
class Problem2273 {

    fun removeAnagrams(words: Array<String>): List<String> {
        val result = mutableListOf(words.first())
        words.drop(1).forEach { word ->
            if (!calcLetterCount(result.last()).contentEquals(calcLetterCount(word))) result.add(word)
        }
        return result
    }

    private fun calcLetterCount(word: String): IntArray {
        val result = IntArray(26)
        word.forEach { char -> result[char - 'a']++ }
        return result
    }
}

fun main() {
    val problem = Problem2273()

    runDynamicTest("test1") {
        val actual = problem.removeAnagrams(arrayOf("abba", "baba", "bbaa", "cd", "cd"))
        check(actual == listOf("abba", "cd")) { "Test failed: Expected [abba, cd], actual: $actual" }
    }
}
