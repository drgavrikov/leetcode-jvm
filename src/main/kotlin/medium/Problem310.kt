package medium

import java.util.*
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-height-trees/solutions/5064427/centroids-search-two-approaches/
 */
class Problem310 {

    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        val degrees = IntArray(n) { 0 }
        val graph = Array(n) { mutableListOf<Int>() }

        edges.forEach { (from, to) ->
            graph[from].add(to)
            graph[to].add(from)

            degrees[from]++
            degrees[to]++
        }

        val leaves: Deque<Int> = LinkedList()
        degrees.forEachIndexed { vertex, degree -> if (degree == 1) leaves.add(vertex) }

        var remainingVertexes = n
        while (remainingVertexes > 2) {
            val size = leaves.size
            repeat(size) {
                val leaf = leaves.removeFirst()
                graph[leaf].forEach { vertex ->
                    degrees[vertex]--
                    if (degrees[vertex] == 1) leaves.addLast(vertex)
                }
            }
            remainingVertexes -= size
        }

        return leaves.toList()
    }

    private fun bfs(tree: Array<MutableList<Int>>, source: Int): List<Int> {
        val distances = Array(tree.size) { Int.MAX_VALUE }
        distances[source] = 0
        val queue = LinkedList<Int>()
        queue.addLast(source)
        while (queue.isNotEmpty()) {
            val vertex = queue.removeFirst()
            tree[vertex].forEach { next ->
                if (distances[next] > distances[vertex] + 1) {
                    distances[next] = distances[vertex] + 1
                    queue.addFirst(next)
                }
            }
        }
        return distances.toList()
    }

    fun findMinHeightTrees2(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        val tree = Array(n) { mutableListOf<Int>() }
        edges.forEach { (from, to) ->
            tree[from].add(to)
            tree[to].add(from)
        }
        val distance = bfs(tree, 0)
        val source = distance.indexOf(distance.maxOf { it })
        val distance1 = bfs(tree, source)
        val sink = distance1.indexOf(distance1.maxOf { it })
        val distance2 = bfs(tree, sink)

        val diameter = distance2.maxOf { it }

        val result = mutableListOf<Int>()
        (0 until n).forEach { vertex ->
            if (distance1[vertex] + distance2[vertex] == diameter && min(distance1[vertex], distance2[vertex]) >= diameter / 2)
                result.add(vertex)
        }
        return result.toList()
    }
}

fun main() {
    val problem = Problem310()
    val edges1 = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(1, 3)
    )
    check(listOf(1) == problem.findMinHeightTrees(4, edges1))
    check(listOf(1) == problem.findMinHeightTrees2(4, edges1))

    val edges2 = arrayOf(
        intArrayOf(3, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
        intArrayOf(3, 4),
        intArrayOf(5, 4)
    )
    check(listOf(3, 4) == problem.findMinHeightTrees(6, edges2))
    check(listOf(3, 4) == problem.findMinHeightTrees2(6, edges2))
}
