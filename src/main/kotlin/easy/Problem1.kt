package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/two-sum/solutions/5036147/one-pass-hash-map/
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

fun main() {
    val problem = Problem1()
    assert(problem.twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(0, 1)))
}
