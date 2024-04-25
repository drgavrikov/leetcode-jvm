/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/3sum/
 */
class Problem15 {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        nums.sort()

        val result = mutableSetOf<List<Int>>()
        for (first in 0..nums.size - 2) {
            var second = first + 1
            var third = nums.size - 1
            while (second < third) {
                val sum = nums[first] + nums[second] + nums[third]
                when {
                    sum == 0 -> result.add(listOf(nums[first], nums[second++], nums[third--]))
                    sum < 0 -> second++
                    else -> third--
                }
            }
        }
        return result.toList()
    }
}

fun main() {
    val problem = Problem15()

    val actual = problem.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    check(actual == listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))) {
        "Expected ${listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))}, but got: $actual"
    }
}
