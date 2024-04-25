/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-islands/solutions/3375942/koltin-solution-use-dfs/
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

            val dx = intArrayOf(0,  0, 1, -1)
            val dy = intArrayOf(1, -1, 0,  0)

            (0..3).forEach { index -> dfs(x + dx[index], y + dy[index]) }
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

fun main() {
    val problem200 = Problem200()
    val actual = problem200.numIslands(
        arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )
    )
    check(actual == 3)
}