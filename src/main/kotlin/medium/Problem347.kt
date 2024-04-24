package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/top-k-frequent-elements/
 */
class Problem347 {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequency = nums.toList().groupingBy { it }.eachCount()
        return frequency
            .map { Pair(-it.value, it.key) }
            .sortedWith(compareBy({ it.first }, { it.second }))
            .map { it.second }
            .take(k)
            .toIntArray()
    }
}

fun main() {
    val problem = Problem347()
    val actual = problem.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
    check(actual.contentEquals(intArrayOf(1, 2)))
}
