/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/single-number/
 */
class Problem136 {
    fun singleNumber(nums: IntArray): Int {
        val numSet = hashSetOf<Int>()
        nums.forEach { num ->
            if (numSet.contains(num)) numSet.remove(num)
            else numSet.add(num)
        }
        return numSet.first()
    }
}

fun main() {
    val problem136 = Problem136()

    val actual1 = problem136.singleNumber(intArrayOf(2, 2, 1))
    check(actual1 == 1) { "Test failed: Expected 1, actual: $actual1" }

    val actual2 = problem136.singleNumber(intArrayOf(4, 1, 2, 1, 2))
    check(actual2 == 4) { "Test failed: Expected 4, actual: $actual2" }

    val actual3 = problem136.singleNumber(intArrayOf(1))
    check(actual3 == 1) { "Test failed: Expected 1, actual: $actual3" }
}
