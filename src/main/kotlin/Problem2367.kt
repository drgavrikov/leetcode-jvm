/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-arithmetic-triplets/
 */
class Problem2367 {

    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val numSet = nums.toHashSet()
        return nums.count { num -> numSet.contains(num + diff) && numSet.contains(num + 2 * diff) }
    }
}

fun main() {
    val problem = Problem2367()

    val nums = intArrayOf(0, 1, 4, 6, 7, 10)
    val diff = 3
    val actual = problem.arithmeticTriplets(nums, diff)
    check(actual == 2) { "Test failed: Expected 2, actual: $actual" }
}
