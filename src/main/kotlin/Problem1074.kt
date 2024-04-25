/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 */
class Problem1074 {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val n = matrix.size
        check(n >= 1)
        val m = matrix[0].size
        check(m >= 1)

        calcPrefixColumnsSum(matrix)
        return calcNumSubmatrixSumTarget(matrix, target)
    }

    private fun calcPrefixColumnsSum(matrix: Array<IntArray>) {
        val n = matrix.size
        val m = matrix[0].size
        for (row in 1 until n) {
            for (col in 0 until m) {
                matrix[row][col] += matrix[row - 1][col]
            }
        }
    }

    private fun calcNumSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val n = matrix.size
        val m = matrix[0].size
        var result = 0
        for (row in 0 until n) {
            for (i in row until n) {
                var submatrixSum = 0
                val submatrixSumCount = hashMapOf(0 to 1)
                for (j in 0 until m) {
                    submatrixSum += matrix[i][j] - if (row > 0) matrix[row - 1][j] else 0
                    result += submatrixSumCount.getOrDefault(submatrixSum - target, 0)
                    submatrixSumCount[submatrixSum] = submatrixSumCount.getOrDefault(submatrixSum, 0) + 1
                }
            }
        }
        return result
    }
}

fun main() {
    val problem1074 = Problem1074()

    val actual1 = problem1074.numSubmatrixSumTarget(
        arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0)),
        0
    )
    check(actual1 == 4) { "Test failed: Expected 4, actual: $actual1" }

    val actual2 = problem1074.numSubmatrixSumTarget(
        arrayOf(
            intArrayOf(0, 1, 1, 1, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0, 0, 1),
            intArrayOf(1, 1, 0, 1, 1, 0),
            intArrayOf(1, 0, 0, 1, 0, 0)
        ),
        0
    )
    check(actual2 == 43) { "Test failed: Expected 43, actual: $actual2" }
}

