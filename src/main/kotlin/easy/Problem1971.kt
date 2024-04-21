package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-if-path-exists-in-graph/solutions/5053892/dfs-bfs-solution/
 */
class Problem1971 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

        val used = BooleanArray(n) {false}

        val graph = Array(n) { mutableListOf<Int>() }
        edges.forEach { edge ->
            val from = edge[0]
            val to = edge[1]
            graph[from].add(to)
            graph[to].add(from)
        }

        fun dfs(vertex: Int) {
            if (used[vertex]) return
            used[vertex] = true
            for (next in graph[vertex])
                dfs(next)
        }

        dfs(source)
        return used[destination]
    }
}

fun main() {
    val problem = Problem1971()
    check(problem.validPath(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), 0, 2))
}
