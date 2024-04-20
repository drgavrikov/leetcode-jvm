package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-all-groups-of-farmland/solutions/5051145/solution-without-dsf-bfs-and-additional-memory/
 */
class Problem1992 {

    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        val n = land.size
        val m = land[0].size

        for (row in 0 until n) {
            for (col in 0 until m) {
                if (
                    land[row][col] == 1 &&
                    (row - 1 < 0 || land[row - 1][col] == 0) &&
                    (col - 1 < 0 || land[row][col - 1] == 0)
                ) {
                    var row2 = row
                    while (row2 + 1 < n && land[row2 + 1][col] == 1) row2++
                    var col2 = col
                    while (col2 + 1 < m && land[row][col2 + 1] == 1) col2++
                    result.add(intArrayOf(row, col, row2, col2))
                }
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val problem = Problem1992()
    val actual = problem.findFarmland(arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 1, 1),
        )
    )
    check(actual[0].contentEquals(intArrayOf(0, 0, 0, 0)) && actual[1].contentEquals(intArrayOf(1, 1, 2, 2)))
}
