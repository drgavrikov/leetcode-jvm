import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/most-profit-assigning-work/solutions/5337100/greedy-sorting-solution/
 */
class Problem826 {

    data class DifficultyProfit(val difficulty: Int, var profit: Int)

    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val size = profit.size
        val sortedProfitDifficulty = difficulty.zip(profit)
            .map { DifficultyProfit(it.first, it.second) }
            .sortedBy { it.difficulty }

        worker.sort()

        (1 until size).forEach { index ->
            sortedProfitDifficulty[index].profit =
                max(sortedProfitDifficulty[index - 1].profit, sortedProfitDifficulty[index].profit)
        }

        var difficultIndex = -1
        return worker.sumOf { current ->
            while (difficultIndex + 1 < size && sortedProfitDifficulty[difficultIndex + 1].difficulty <= current) {
                difficultIndex++
            }
            if (difficultIndex != -1) sortedProfitDifficulty[difficultIndex].profit else 0
        }
    }
}

fun main() {
    val problem = Problem826()

    val difficulty = intArrayOf(2, 4, 6, 8, 10)
    val profit = intArrayOf(10, 20, 30, 40, 50)
    val worker = intArrayOf(4, 5, 6, 7)
    check(problem.maxProfitAssignment(difficulty, profit, worker) == 100)
}
