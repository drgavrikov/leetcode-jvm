/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/subarray-sum-equals-k/
 */
class Problem560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val sumCount = mutableMapOf<Int, Int>()

        var prefixSum = 0
        sumCount[prefixSum] = 1

        var result = 0
        nums.forEach { num ->
            prefixSum += num
            result += sumCount.getOrDefault(prefixSum - k, 0)

            sumCount[prefixSum] = sumCount.getOrDefault(prefixSum, 0) + 1

        }
        return result
    }
}

fun main() {
    val problem = Problem560()
    val actual = problem.subarraySum(intArrayOf(1, 2, 3), 3)
    check(actual == 2)
}
