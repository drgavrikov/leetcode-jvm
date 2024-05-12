/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/relative-ranks/solutions/5147306/sort-and-reverse-with-array-index/
 */
class Problem506 {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val indexedScore = score
            .mapIndexed { index, num -> Pair(num, index) }
            .sortedByDescending { it.first }
        val size = score.size
        val result = Array(size) { "" }

        val medals = listOf("Gold Medal", "Silver Medal", "Bronze Medal")
        for (index in 0 until 3) {
            result[indexedScore[index].second] = medals[index]
        }
        for (index in 3 until score.size) {
            result[indexedScore[index].second] = (index + 1).toString()
        }
        return result
    }
}

fun main() {
    val problem = Problem506()
    val score = intArrayOf(5, 4, 3, 2, 1)
    assert(
        problem.findRelativeRanks(score = score)
            .contentEquals(arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"))
    )
}
