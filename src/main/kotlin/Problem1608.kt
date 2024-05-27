import kotlin.math.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/solutions/5218366/counting-and-prefix-sum-techniques/
 */
class Problem1608 {
    fun specialArray(nums: IntArray): Int {
        val n = nums.size
        val freq = IntArray(n + 1)
        nums.forEach { num -> freq[min(n, num)]++ }
        var sum = 0
        for (num in n downTo 0) {
            sum += freq[num]
            if (sum == num) return num
        }
        return -1
    }
}

fun main() {
    val problem1608 = Problem1608()
    check(problem1608.specialArray(intArrayOf(3, 5)) == 2) { "Test 1 failed" }
    check(problem1608.specialArray(intArrayOf(0, 0)) == -1) { "Test 2 failed" }
}
