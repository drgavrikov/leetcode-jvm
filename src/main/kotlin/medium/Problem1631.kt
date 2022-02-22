package medium

import java.util.*
import kotlin.math.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/path-with-minimum-effort/
 */
class Problem1631 {

    data class Point(val x: Int, val y: Int)

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val dx = intArrayOf(0,  0, 1, -1)
        val dy = intArrayOf(1, -1, 0,  0)

        val n = heights.size
        val m = heights[0].size

        val efforts = Array(n) { Array(m) { Int.MAX_VALUE / 2 } }

        fun check(p: Point) = p.x in 0 until n && p.y in 0 until m

        val queue = LinkedList<Point>()
        queue.add(Point(0, 0))
        efforts[0][0] = 0

        while (!queue.isEmpty()) {
            val p = queue.pop()!!
            for (i in 0 until dx.size) {
                val np = Point(p.x + dx[i], p.y + dy[i])
                if (!check(np)) continue
                val nextEffort = max(efforts[p.x][p.y], abs(heights[p.x][p.y] - heights[np.x][np.y]))
                if (nextEffort < efforts[np.x][np.y]) {
                    queue.add(np)
                    efforts[np.x][np.y] = nextEffort
                }
            }
        }
        return efforts[n - 1][m - 1]
    }
}
