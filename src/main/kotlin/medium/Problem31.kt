package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/next-permutation/
 */
class Problem31 {

    fun nextPermutation(nums: IntArray) {

        val i = (0..nums.size - 2).lastOrNull { index -> nums[index] < nums[index + 1] } ?: -1
        if (i == -1) {
            nums.indices.forEach { index -> nums[index] = index + 1 }
            return
        }
        val j = (i + 1 until nums.size)
            .filter { index -> nums[index] > nums[i] }
            .minByOrNull { index -> nums[index] }!!

        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

        nums.reverse(i + 1, nums.size)
    }

}
