/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/count-number-of-nice-subarrays/solutions/5353007/prefix-sum-solution/
 */
class Problem1248 {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var currentSum = 0
        var result = 0
        val prefixSumCount = HashMap<Int, Int>()
        prefixSumCount[0] = 1
        nums.forEach { num ->
            currentSum += num % 2
            result += prefixSumCount.getOrDefault(currentSum - k, 0)
            prefixSumCount[currentSum] = prefixSumCount.getOrDefault(currentSum, 0) + 1
        }
        return result
    }
}

fun main() {
    val problem = Problem1248()
    check(problem.numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3) == 2)
}
