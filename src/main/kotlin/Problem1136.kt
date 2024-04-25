import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/parallel-courses/
 */
class Problem1136 {
    fun minimumSemesters(n: Int, relations: Array<IntArray>): Int {
        val graph = relations
            .map { relation -> Pair(relation[0] - 1, relation[1] - 1) }
            .groupBy({ it.second }, { it.first })
            .toMap()

        val depth = MutableList(n) { 1 }
        val color = MutableList(n) { 0 }

        var cycle = false

        fun dfs(v: Int): Int {
            if (color[v] == 2) return depth[v]
            if (color[v] == 1) cycle = true
            if (cycle) return -1

            color[v] = 1

            graph.getOrDefault(v, emptyList()).forEach { next ->
                dfs(next)
                depth[v] = max(depth[v], dfs(next) + 1)
            }

            color[v] = 2
            return depth[v]
        }
        (0 until n).forEach { v -> dfs(v) }
        return if (cycle) -1 else depth.maxOrNull()!!
    }
}

fun main() {
    val problem1136 = Problem1136()

    val actual1 = problem1136.minimumSemesters(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))
    check(actual1 == 2) { "Test 1 failed" }

    val actual2 = problem1136.minimumSemesters(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1)))
    check(actual2 == -1) { "Test 2 failed" }
}

