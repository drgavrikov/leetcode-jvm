package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-islands/
 */
class Problem200 {

    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid.first().size

        fun isCorrectCoord(x: Int, y: Int) = (x in 0 until n) && (y in 0 until m)

        fun dfs(x: Int, y: Int) {
            if (!isCorrectCoord(x, y)) return
            if (grid[x][y] == '0') return
            grid[x][y] = '0'
            dfs(x, y + 1)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x - 1, y)
        }

        var result = 0
        (0 until n).forEach { x ->
            (0 until m).forEach { y ->
                if (grid[x][y] == '1') {
                    dfs(x, y)
                    result++
                }
            }
        }
        return result
    }
}
