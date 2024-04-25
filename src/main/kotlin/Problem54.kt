/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/spiral-matrix/
 */
class Problem54 {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size

        val result = mutableListOf<Int>()

        var top = 0
        var bottom = n - 1
        var left = 0
        var rigth = m - 1

        while (true) {
            for (col in left..rigth) result.add(matrix[top][col])
            top++
            if (top > bottom) break

            for (row in top..bottom) result.add(matrix[row][rigth])
            rigth--
            if (left > rigth) break

            for (col in rigth downTo left) result.add(matrix[bottom][col])
            bottom--
            if (top > bottom) break

            for (row in bottom downTo top) result.add(matrix[row][left])
            left++
            if (left > rigth) break
        }
        return result
    }
}

fun main() {
    val problem = Problem54()

    val actual1 = problem.spiralOrder(
        arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    )
    check(actual1 == listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)) {
        "Test 1 failed: Expected [1, 2, 3, 6, 9, 8, 7, 4, 5], but got $actual1"
    }

    val actual2 = problem.spiralOrder(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
    )
    check(actual2 == listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)) {
        "Test 2 failed: Expected [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7], but got $actual2"
    }
}
