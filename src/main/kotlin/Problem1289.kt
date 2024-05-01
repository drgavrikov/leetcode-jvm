/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-falling-path-sum-ii/solutions/5095519/iterative-dp-with-space-optimization/
 */
class Problem1289 {

    fun minFallingPathSum(grid: Array<IntArray>): Int {
        var firstMin = Pair(0, -1)
        var secondMin = Pair(0, -1)

        for (row in grid) {

            var nextFirstMin = Pair(Int.MAX_VALUE / 2, -1)
            var nextSecondMin = Pair(Int.MAX_VALUE / 2, -1)

            row.forEachIndexed { index, value ->
                val current = Pair(value + (if (index == firstMin.second) secondMin.first else firstMin.first), index)
                if (current.first < nextFirstMin.first) {
                    nextSecondMin = nextFirstMin
                    nextFirstMin = current
                } else if (current.first < nextSecondMin.first) {
                    nextSecondMin = current
                }
            }

            firstMin = nextFirstMin
            secondMin = nextSecondMin
        }
        return firstMin.first
    }
}

fun main() {
    val problem1289 = Problem1289()

    val actual1 = problem1289.minFallingPathSum(arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9))
    )
    check(actual1 == 13) { "Test failed: Expected 13, actual: $actual1" }
}

