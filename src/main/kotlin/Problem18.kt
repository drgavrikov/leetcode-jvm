/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/4sum/
 */
class Problem18 {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val n = nums.size
        val result = mutableSetOf<List<Int>>()
        for (index1 in 0 until n - 3) {
            for (index2 in index1 + 1 until n - 2) {
                var index3 = index2 + 1
                var index4 = n - 1
                while (index3 < index4) {
                    val sum = nums[index1].toLong() + nums[index2] + nums[index3] + nums[index4]
                    if (sum == target.toLong()) {
                        result.add(listOf(nums[index1], nums[index2], nums[index3], nums[index4]))
                        index3++
                        index4--
                    } else if (sum < target) index3++
                    else index4--
                }
            }
        }
        return result.toList()
    }
}

fun main() {
    val problem = Problem18()
    val actual = problem.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0)
    check(actual == listOf(listOf(-2, -1, 1, 2), listOf(-2, 0, 0, 2), listOf(-1, 0, 0, 1)))
}
