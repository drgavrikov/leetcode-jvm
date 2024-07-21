/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/solutions/5508499/greedy-approach/
 */
class Problem1605 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        return (rowSum.indices).map { row ->
            (colSum.indices).map { col ->
                val value = minOf(rowSum[row], colSum[col])
                rowSum[row] -= value
                colSum[col] -= value
                value
            }.toIntArray()
        }.toTypedArray()
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
