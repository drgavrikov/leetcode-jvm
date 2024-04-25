import java.util.*
import kotlin.math.abs

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 */
class Problem1284 {
    class Matrix(private val matrix: List<List<Int>>) {

        constructor(mat: Array<IntArray>) : this(mat.map { it.toList() }.toList())

        init {
            check(matrix.isNotEmpty())
            check(matrix.all { it.size == matrix[0].size })
        }

        private fun n() = matrix.size

        private fun m() = matrix[0].size

        fun isZero(): Boolean {
            return matrix.flatten().all { it == 0 }
        }

        fun flipMatrices(): List<Matrix> {
            return (0 until n()).flatMap { row ->
                (0 until m()).map { col ->
                    flip(row, col)
                }.toList()
            }.toList()
        }

        private fun flip(flipRow: Int, flipCol: Int): Matrix {
            val flipMatrix =
                (0 until n()).map { row ->
                    (0 until m()).map { col ->
                        if (edge(row, col, flipRow, flipCol)) flip(matrix[row][col]) else matrix[row][col]
                    }.toList()
                }.toList()
            return Matrix(flipMatrix)
        }

        private fun edge(row1: Int, col1: Int, row2: Int, col2: Int): Boolean {
            return (row1 == row2 && abs(col1 - col2) <= 1) || (col1 == col2 && abs(row1 - row2) <= 1)
        }

        private fun flip(value: Int): Int {
            return (value + 1) % 2
        }

        override fun toString(): String {
            return matrix.joinToString(separator = "") { it.toString() + "\n" }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Matrix

            if (matrix != other.matrix) return false

            return true
        }

        override fun hashCode(): Int {
            return matrix.hashCode()
        }
    }

    fun minFlips(mat: Array<IntArray>): Int {
        return dfs(Matrix(mat))
    }

    private fun dfs(matrix: Matrix): Int {
        val dist = mutableMapOf<Matrix, Int>()
        dist[matrix] = 0
        val queue = LinkedList<Matrix>()
        queue.add(matrix)
        while (!queue.isEmpty()) {
            val current = queue.poll()
            if (current.isZero()) return dist.getValue(current)
            current.flipMatrices().forEach { next ->
                if (!dist.containsKey(next)) {
                    dist[next] = dist.getValue(current) + 1
                    queue.add(next)
                }
            }

        }
        return -1
    }
}

fun main() {
    val problem1284 = Problem1284()

    val actual1 = problem1284.minFlips(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)))
    check(actual1 == 3) { "Test failed: Expected 3, actual: $actual1" }

    val actual2 = problem1284.minFlips(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
    check(actual2 == 0) { "Test failed: Expected 0, actual: $actual2" }
}

