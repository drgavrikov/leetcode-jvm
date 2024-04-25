import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/valid-square/
 */
class Problem61 {

    fun minPathSum(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        val dist = Array(n) { Array(m) { Int.MAX_VALUE } }
        dist[0][0] = grid[0][0]
        for (i in 1 until n) dist[i][0] = dist[i - 1][0] + grid[i][0]
        for (i in 1 until m) dist[0][i] = dist[0][i - 1] + grid[0][i]

        for (i in 1 until n)
            for (j in 1 until m)
                dist[i][j] = min(dist[i - 1][j], dist[i][j - 1]) + grid[i][j]

        return dist[n - 1][m - 1]
    }
}

fun main() {
    val problem61 = Problem61()

    val actual = problem61.minPathSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    check(actual == 12) { "Test 1 failed: Expected 12, but got $actual" }
}
