/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/relative-sort-array/solutions/5295118/ordinal-sorting-with-linear-complexity/
 */
class Problem1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val indices = arr2.withIndex().associate { it.value to it.index }
        return arr1.sortedBy { num -> indices[num] ?: (num + arr2.size) }.toIntArray()
    }
}

fun main() {
    val problem = Problem1122()

    val actual = problem.relativeSortArray(intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), intArrayOf(2, 1, 4, 3, 9, 6))
    check(actual.contentEquals(intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19))) { "Test 1 failed" }
}

