import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/path-with-maximum-gold/description/
 */
class Problem1219 {
    fun getMaximumGold(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        fun check(x: Int, y: Int): Boolean {
            return x in 0 until n && y in 0 until m
        }

        val dx = intArrayOf(0, 0, 1, -1)
        val dy = intArrayOf(1, -1, 0, 0)

        var maxScore = 0

        val used = Array(n) { BooleanArray(m) { false } }

        fun dfsBacktrack(x: Int, y: Int, score: Int = 0) {
            maxScore = max(maxScore, score)
            if (!check(x, y)) return
            if (grid[x][y] == 0) return
            used[x][y] = true
            val cellScore = grid[x][y]
            grid[x][y] = 0
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                dfsBacktrack(nx, ny, score + cellScore)
            }
            grid[x][y] = cellScore
        }

        fun calcDeg(x: Int, y: Int): Int {
            var deg = 0
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (check(nx, ny) && grid[nx][ny] != 0) deg++
            }
            return deg
        }

        for (x in 0 until n) {
            for (y in 0 until m) {
                val deg = calcDeg(x, y)
                if (deg <= 1) dfsBacktrack(x, y)
            }
        }

        val sources = mutableListOf<Pair<Int, Int>>()
        for (x in 0 until n) {
            for (y in 0 until m) {
                if (!used[x][y] && calcDeg(x, y) == 2) sources.add(Pair(x, y))
            }
        }
        sources.forEach { dfsBacktrack(it.first, it.second) }

        return maxScore
    }
}

fun main() {
    val problem = Problem1219()
    val result = problem.getMaximumGold(arrayOf(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1))
    )
    assert(result == 19)
}

