/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/combinations/solutions/4999254/solution-without-recursion/
 */
class Problem77 {

    private fun nextCombination(combination: IntArray, n: Int, k: Int): Boolean {
        var index = k - 1
        while (index >= 0 && combination[index] == n - k + index + 1) index--
        if (index == -1) return false
        combination[index]++
        for (j in index + 1 until k) combination[j] = combination[j - 1] + 1
        return true
    }

    fun combine(n: Int, k: Int): List<List<Int>> {
        val combination = (1..k).map { it }.toIntArray()
        val result = mutableListOf<List<Int>>()
        do {
            result.add(combination.toList())
        } while (nextCombination(combination, n, k))
        return result
    }
}

fun main() {
    val problem = Problem77()
    check(problem.combine(4, 2) == listOf(
        listOf(1, 2),
        listOf(1, 3),
        listOf(1, 4),
        listOf(2, 3),
        listOf(2, 4),
        listOf(3, 4),
        )
    )
}
