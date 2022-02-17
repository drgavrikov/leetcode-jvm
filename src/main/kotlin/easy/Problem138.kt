package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/single-number/
 */
class Problem138 {
    fun singleNumber(nums: IntArray): Int {
        val numSet = hashSetOf<Int>()
        nums.forEach { num ->
            if (numSet.contains(num)) numSet.remove(num)
            else numSet.add(num)
        }
        return numSet.first()
    }
}
