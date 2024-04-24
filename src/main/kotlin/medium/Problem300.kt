package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-increasing-subsequence/
 */
class Problem300 {

    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val d = IntArray(n + 1) { Int.MAX_VALUE / 2 }
        d[0] = Int.MIN_VALUE / 2
        nums.forEach { num ->
            var left = 0
            var right = n
            while (left < right) {
                val mid = (left + right) / 2
                if (d[mid] < num) left = mid + 1
                else right = mid
            }
            if (num < d[left]) d[left] = num
        }
        return d.indexOfLast { it < Int.MAX_VALUE / 2 }
    }
}

fun main() {
    val problem = Problem300()
    val actual = problem.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))
    check(actual == 4)

    val actual2 = problem.lengthOfLIS(intArrayOf(0))
    check(actual2 == 1)

    val actual3 = problem.lengthOfLIS(intArrayOf(0, 1, 2, 3, 4, 5))
    check(actual3 == 6)
}
