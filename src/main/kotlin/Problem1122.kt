/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/relative-sort-array/solutions/5295118/ordinal-sorting-with-linear-complexity/
 */
class Problem1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val max = arr1.maxOrNull()!!
        val counts = IntArray(max + 1) { 0 }
        arr1.forEach { num -> counts[num]++ }

        var index = 0
        arr2.forEach { num ->
            repeat(counts[num]) { arr1[index++] = num }
            counts[num] = 0
        }
        counts.forEachIndexed { num, count ->
            repeat(count) { arr1[index++] = num }
        }
        return arr1
    }
}

fun main() {
    val problem = Problem1122()

    val actual = problem.relativeSortArray(intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), intArrayOf(2, 1, 4, 3, 9, 6))
    check(actual.contentEquals(intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19))) { "Test 1 failed" }
}

