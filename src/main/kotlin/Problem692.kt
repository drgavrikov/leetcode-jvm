/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/top-k-frequent-words
 */
class Problem692 {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val frequency = words.groupingBy { it }.eachCount()
        return frequency
            .asSequence()
            .map { Pair(it.key, it.value) }
            .toList()
            .sortedWith(compareBy({ -it.second }, { it.first }))
            .map { it.first }
            .take(k)
            .toList()
    }
}

fun main() {
    val problem692 = Problem692()
    check(problem692.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2) == listOf("i", "love"))
}
