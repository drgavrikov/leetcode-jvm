package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/sort-array-by-parity/
 */
class Problem905 {
    fun sortArrayByParity(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 0 }
        var index = 0
        for (num in nums) if (num % 2 == 0) result[index++] = num
        for (num in nums) if (num % 2 == 1) result[index++] = num
        return result
    }
}

fun main() {
    val problem905 = Problem905()

    runDynamicTest("test1") {
        val actual = problem905.sortArrayByParity(intArrayOf(3, 1, 2, 4))
        check(actual.contentEquals(intArrayOf(2, 4, 3, 1))) { "Test failed: Expected [2, 4, 3, 1], actual: ${actual.contentToString()}" }
    }
}
