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

fun main() {
    val problem118 = Problem118()

    runDynamicTest("test1") {
        val actual = problem118.generate(5)
        val triangle = listOf(
            listOf(1),
            listOf(1, 1),
            listOf(1, 2, 1),
            listOf(1, 3, 3, 1),
            listOf(1, 4, 6, 4, 1)
        )
        check(actual == triangle) { "Test failed: Expected $triangle, actual: $actual" }
    }
}
