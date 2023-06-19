package easy

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
