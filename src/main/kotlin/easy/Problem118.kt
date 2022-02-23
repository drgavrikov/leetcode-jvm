package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/pascals-triangle/
 */
class Problem118 {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = (0 until numRows).map { MutableList(it + 1) { 1 } }.toList()
        for (i in (0 until numRows)) {
            for (j in (1 until i))
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
        }
        return triangle
    }
}
