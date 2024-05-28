import kotlin.math.abs
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/get-equal-substrings-within-budget/solutions/5223242/sliding-window/
 */
class Problem1208 {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var currentCost = 0
        var maxLength = 0
        var leftPointer = 0

        for (rightPointer in s.indices) {
            currentCost += abs(s[rightPointer] - t[rightPointer])
            while (leftPointer <= rightPointer && currentCost > maxCost) {
                currentCost -= abs(s[leftPointer] - t[leftPointer])
                leftPointer++
            }
            maxLength = max(maxLength, rightPointer - leftPointer + 1)
        }

        return maxLength
    }
}

fun main() {
    val problem = Problem1208()
    check(problem.equalSubstring("abcd", "bcdf", 3) == 3)
    check(problem.equalSubstring("abcd", "cdef", 3) == 3)
    check(problem.equalSubstring("abcd", "cbef", 0) == 1)
}

