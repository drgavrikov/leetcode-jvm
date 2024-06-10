/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/replace-words/solutions/5292062/hash-set-solution-with-linear-complexity/
 */
class Problem648 {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val dict = dictionary.toHashSet()
        return sentence.split(" ").map { word ->
            val prefix = StringBuilder("")
            for (ch in word) {
                prefix.append(ch)
                if (prefix.toString() in dict) return@map prefix
            }
            word
        }.joinToString(separator = " ")
    }
}

fun main() {
    val problem = Problem648()
    check(problem.replaceWords(
        listOf("cat","bat","rat"),
        "the cattle was rattled by the battery"
    ) == "the cat was rat by the bat") { "Test 1 failed" }
}
