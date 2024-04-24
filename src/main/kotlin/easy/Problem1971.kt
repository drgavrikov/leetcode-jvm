package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-if-path-exists-in-graph/solutions/5053892/dfs-bfs-solution/
 */
class Problem1971 {

    class DSU(val n: Int) {
        private val root = IntArray(n) { it }
        private val rank = IntArray(n) { 1 }

        fun findRoot(v: Int): Int {
            if (root[v] == v) return v
            root[v] = findRoot(root[v])
            return root[v]
        }

        fun union(v: Int, w: Int) {
            val rootV = findRoot(v)
            val rootW = findRoot(w)
            if (rootV != rootW) {
                if (rank[rootV] > rank[rootW]) {
                    rank[rootV] += rank[rootW]
                    root[rootW] = rootV
                } else {
                    rank[rootW] += rank[rootV]
                    root[rootV] = rootW
                }
            }
        }
    }

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val dsu = DSU(n)
        edges.forEach { edge -> dsu.union(edge[0], edge[1]) }
        return dsu.findRoot(source) == dsu.findRoot(destination)
    }
}

fun main() {
    val problem = Problem1971()
    check(problem.validPath(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), 0, 2))
}
