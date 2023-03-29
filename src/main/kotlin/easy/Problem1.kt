package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/two-sum/
 */
class Problem1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val index = nums.indices.first { index ->
            val num = nums[index]
            map.contains(target - num).also { map[num] = index }
        }
        return intArrayOf(map.getValue(target - nums[index]), index)
    }
}
