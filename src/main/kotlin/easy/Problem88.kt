package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/merge-sorted-array/description/
 */
class Problem88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var index1 = m - 1
        var index2 = n - 1
        var index = n + m - 1
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[index--] = nums1[index1--]
            } else {
                nums1[index--] = nums2[index2--]
            }
        }
        while (index2 >= 0) nums1[index--] = nums2[index2--]
    }
}

fun main() {
    val problem = Problem88()

    runDynamicTest("test1") {
        val num1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val n = 3
        val num2 = intArrayOf(2, 5, 6)
        val m = 3
        problem.merge(num1, n, num2, m)
        check(num1.contentEquals(intArrayOf(1, 2, 2, 3, 5, 6))) { "Test failed: Expected [1, 2, 2, 3, 5, 6], actual: ${num1.contentToString()}" }
    }
}
