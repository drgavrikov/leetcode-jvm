package easy

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
