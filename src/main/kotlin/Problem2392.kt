import java.util.LinkedList
import java.util.Queue

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/build-a-matrix-with-conditions/solutions/5512138/kahn-s-topological-sort-solution/
 */
class Problem2392 {

    private fun topologicalSort(size: Int, edges: Array<IntArray>): List<Int> {
        val adjacencyList = List(size) { mutableListOf<Int>() }
        val inDegrees = IntArray(size) { 0 }

        for ((from, to) in edges) {
            adjacencyList[from - 1].add(to - 1)
            inDegrees[to - 1]++
        }

        val queue: Queue<Int> = LinkedList()
        inDegrees.forEachIndexed { vertex, degree -> if (degree == 0) queue.add(vertex) }

        val sortedVertexes = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()!!
            sortedVertexes.add(vertex)

            for (neighbor in adjacencyList[vertex]) {
                inDegrees[neighbor]--
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }
        sortedVertexes.reverse()
        return sortedVertexes
    }

    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        val sortedRow = topologicalSort(k, rowConditions)
        val sortedCol = topologicalSort(k, colConditions)
        if (sortedRow.size != k || sortedCol.size != k) return emptyArray()

        val rowIndexes = IntArray(k) { 0 }
        sortedRow.forEachIndexed { index, value -> rowIndexes[value] = index }

        val colIndexes = IntArray(k) { 0 }
        sortedCol.forEachIndexed { index, value -> colIndexes[value] = index }

        val result = Array(k) { IntArray(k) { 0 } }
        (0 until k).forEach { value -> result[rowIndexes[value]][colIndexes[value]] = value + 1 }
        return result
    }
}

fun main() {
    val problem = Problem2392()
    val k = 3
    val rowConditions = arrayOf(intArrayOf(1, 2), intArrayOf(3, 2))
    val colConditions = arrayOf(intArrayOf(2, 1), intArrayOf(3, 2))

    val matrix = problem.buildMatrix(3, rowConditions, colConditions)
    check(matrix.size == k && matrix.first().size == k)

    val rowIndices = IntArray(k + 1)
    val colIndices = IntArray(k + 1)
    matrix.indices.forEach { row ->
        matrix[row].indices.forEach { col ->
            if (matrix[row][col] > 0) {
                rowIndices[matrix[row][col]] = row
                colIndices[matrix[row][col]] = col
            }
        }
    }
    rowConditions.forEach { (from, to) -> check(rowIndices[from] > rowIndices[to]) }
    colConditions.forEach { (from, to) -> check(colIndices[from] > colIndices[to]) }
}
