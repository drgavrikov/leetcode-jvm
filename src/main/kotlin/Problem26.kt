/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class Problem26 {

    fun removeDuplicates(nums: IntArray): Int {
        val empty = -1000
        var distinctIndex = 0
        for (index in 1 until nums.size) {
            if (nums[distinctIndex] != nums[index]) {
                distinctIndex++
                nums[distinctIndex] = nums[index]
                if (distinctIndex != index) nums[index] = empty
            } else nums[index] = empty
        }
        return distinctIndex + 1
    }
}
