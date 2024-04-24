package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
 */
class Problem2215 {

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        return listOf(
            (nums1.toSet() - nums2.toSet()).toList(),
            (nums2.toSet() - nums1.toSet()).toList()
        )
    }
}

fun main() {
    val problem = Problem2215()

    runDynamicTest("test1") {
        val num1 = intArrayOf(1, 2, 3)
        val num2 = intArrayOf(2, 4, 6)
        val actual = problem.findDifference(num1, num2)
        check(actual == listOf(listOf(1, 3), listOf(4, 6))) { "Test failed: Expected [[1, 3], [4, 6]], actual: $actual" }
    }
}
