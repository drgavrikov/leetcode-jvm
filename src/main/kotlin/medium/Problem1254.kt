package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-closed-islands/
 */
class Problem1254 {
    fun closedIsland(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        val dx = intArrayOf(0, 0, 1, -1)
        val dy = intArrayOf(1, -1, 0, 0)

        fun check(x: Int, y: Int) = 0 <= x && x < n && 0 <= y && y < m

        fun dfs(x: Int, y: Int) {
            if (!check(x, y)) return
            if (grid[x][y] == 1) return
            grid[x][y] = 1
            for (i in 0..3)
                dfs(x + dx[i], y + dy[i])
        }

        for (i in 0 until n) {
            dfs(i, 0)
            dfs(i, m - 1)
        }
        for (i in 0 until m) {
            dfs(0, i)
            dfs(n - 1, i)
        }
        var result = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 0) {
                    dfs(i, j)
                    result++
                }
            }
        }
        return result
    }
}
