package easy

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

    runDynamicTest("test1") {
        val actual = problem136.singleNumber(intArrayOf(2, 2, 1))
        check(actual == 1) { "Test failed: Expected 1, actual: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem136.singleNumber(intArrayOf(4, 1, 2, 1, 2))
        check(actual == 4) { "Test failed: Expected 4, actual: $actual" }
    }

    runDynamicTest("test3") {
        val actual = problem136.singleNumber(intArrayOf(1))
        check(actual == 1) { "Test failed: Expected 1, actual: $actual" }
    }
}
