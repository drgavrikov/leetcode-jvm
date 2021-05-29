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
    val satisfaction1 = intArrayOf(-1, -8, 0, 5, -9)
    check(Problem1402().maxSatisfaction(satisfaction1) == 14)

    val satisfaction2 = intArrayOf(4, 3, 2)
    check(Problem1402().maxSatisfaction(satisfaction2) == 20)
}
