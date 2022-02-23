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
