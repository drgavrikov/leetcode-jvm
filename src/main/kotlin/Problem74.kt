/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/search-a-2d-matrix/
 */
class Problem74 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        val m = matrix[0].size
        var left = 0
        var right = n
        while (left < right) {
            val middle = (left + right) / 2
            if (matrix[middle][m - 1] < target) left = middle + 1
            else right = middle
        }
        check(left == right)
        val row = left
        if (row >= n || target < matrix[row][0] || target > matrix[row][m - 1]) return false

        left = 0
        right = m
        while (left < right) {
            val middle = (left + right) / 2
            if (target == middle) {
                left = middle
                right = middle
                break
            }
            if (matrix[row][middle] < target) left = middle + 1
            else right = middle
        }
        check(left == right)
        if (left >= m) return false
        return matrix[row][left] == target
    }
}

fun main() {
    val problem74 = Problem74()
    val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    check(problem74.searchMatrix(matrix, 3))
}