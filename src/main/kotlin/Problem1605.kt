/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/solutions/5508499/greedy-approach/
 */
class Problem1605 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val n = rowSum.size
        val m = colSum.size
        val matrix = Array(n) { IntArray(m) }
        for (row in 0 until n) {
            for (col in 0 until m) {
                val value = minOf(rowSum[row], colSum[col])
                matrix[row][col] = value
                rowSum[row] -= value
                colSum[col] -= value
            }
        }
        return matrix
    }
}

fun main() {
    val problem = Problem1605()
    val rowSum = intArrayOf(3, 8)
    val colSum = intArrayOf(4, 7)
    val matrix = problem.restoreMatrix(rowSum.copyOf(), colSum.copyOf())
    for (row in matrix.indices) {
        check(matrix[row].sum() == rowSum[row])
    }
    for (col in matrix[0].indices) {
        check(matrix.indices.sumOf { matrix[it][col] } == colSum[col])
    }
}
