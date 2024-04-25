/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-target-indices-after-sorting-array/
 */
class Problem2089 {

    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        val sortedNums = nums.sorted()
        val left = sortedNums.indexOfFirst { it == target }
        val right = sortedNums.indexOfLast { it == target }
        return if (left > -1 && right > -1) (left..right).toList() else listOf()
    }
}

fun main() {
    val problem = Problem2089()

    val nums = intArrayOf(1, 2, 5, 2, 3)
    val actual = problem.targetIndices(nums, 2)
    check(actual == listOf(1, 2)) { "Test failed: Expected [1, 2], actual: $actual" }
}
