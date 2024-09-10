/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 */
class Problem1380 {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val rowMinMax = matrix.indices.maxOf { row -> matrix[row].minOrNull()!! }
        val columnMaxMin = (0 until matrix.first().size).minOf { column -> matrix.maxOf { it[column] } }
        return if (rowMinMax == columnMaxMin) listOf(rowMinMax) else emptyList<Int>()
    }
}

fun main() {
    val problem = Problem1380()
    problem.luckyNumbers(
        arrayOf(
            intArrayOf(3, 7, 8),
            intArrayOf(9, 11, 13),
            intArrayOf(15, 16, 17)
        )
    )
}
