package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-provinces/
 */
class Problem547 {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val visited = BooleanArray(n)

        fun dfs(vertex: Int) {
            if (visited[vertex]) return
            visited[vertex] = true
            (0 until n)
                .filter { isConnected[vertex][it] == 1 }
                .forEach { dfs(it) }
        }

        var result = 0
        (0 until n).forEach { vertex ->
            if (!visited[vertex]) {
                dfs(vertex)
                result++
            }
        }
        return result
    }
}

fun main() {
    val problem547 = Problem547()
    val graph = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )
    check(problem547.findCircleNum(graph) == 2)
}
