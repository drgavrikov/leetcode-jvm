package hard

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/reducing-dishes/
 */
class Problem1402 {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        val sum = accumulate(satisfaction.sortedArrayDescending())
        return (accumulate(sum) + 0).maxOrNull()!!
    }

    private fun accumulate(array: IntArray): IntArray {
        val sum = IntArray(array.size)
        array.forEachIndexed { index, value ->
            sum[index] = value
            if (index > 0) sum[index] += sum[index - 1]
        }
        return sum
    }
}

fun main() {
    val problem1402 = Problem1402()

    runDynamicTest("test1") {
        val actual = problem1402.maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9))
        check(actual == 14) { "Test failed: Expected 14, actual: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem1402.maxSatisfaction(intArrayOf(4, 3, 2))
        check(actual == 20) { "Test failed: Expected 20, actual: $actual" }
    }
}
