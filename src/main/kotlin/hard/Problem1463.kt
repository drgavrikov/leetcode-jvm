package hard

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/cherry-pickup-ii/
 */
class Problem1463 {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val g = Array(rows) { IntArray(cols + 2) { -INF } }
        (0 until rows).forEach { row ->
            (0 until cols).forEach { col ->
                g[row][col + 1] = grid[row][col]
            }
        }
        val z = Array(rows) { Array(cols + 2) { IntArray(cols + 2) { -INF } } }
        z[0][1][cols] = g[0][1] + g[0][cols]

        for (row in 0 until rows - 1) {
            for (col1 in 1..cols) {
                for (col2 in 1..cols) {
                    if (z[row][col1][col2] == INF) continue
                    next(g, z, row, col1, col2)
                }
            }
        }
        return z[rows - 1].map { it.maxOrNull()!! }.maxOrNull()!!
    }

    private val diffCol = intArrayOf(-1, 0, 1)

    private fun next(grid: Array<IntArray>, z: Array<Array<IntArray>>, row: Int, col1: Int, col2: Int) {
        val nextCols1 = diffCol.map { col1 + it }.toList()
        val nextCols2 = diffCol.map { col2 + it }.toList()

        nextCols1.forEach { nextCol1 ->
            nextCols2.forEach { nextCol2 ->
                val diff = grid[row + 1][nextCol1] + if (nextCol1 != nextCol2) grid[row + 1][nextCol2] else 0
                z[row + 1][nextCol1][nextCol2] = max(z[row + 1][nextCol1][nextCol2], z[row][col1][col2] + diff)
            }
        }
    }

    companion object {
        private const val INF = 1000
    }
}
