import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/merge-intervals/
 */
class Problem56 {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy { it[0] })

        val result = mutableListOf(intervals.first())
        intervals.drop(1).forEach { interval ->
            val last = result.last()
            if (last[1] < interval[0]) result.add(interval)
            else last[1] = max(interval[1], last[1])
        }
        return result.toTypedArray()
    }
}

fun main() {
    val problem = Problem56()

    val actual = problem.merge(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
    )
    check(actual contentDeepEquals arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))) {
        "Test 1 failed: Expected [[1, 6], [8, 10], [15, 18]], but got ${actual.contentDeepToString()}"
    }

}
