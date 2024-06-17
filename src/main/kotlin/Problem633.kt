import kotlin.math.sqrt

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/sum-of-square-numbers/
 */
class Problem633 {
    fun judgeSquareSum(c: Int): Boolean {
        for (a in 0 until sqrt(c.toDouble()).toLong() + 1) {
            val b = sqrt((c - a * a).toDouble()).toLong()
            if (b * b == c - a * a) return true
        }
        return false
    }
}

fun main() {
    val problem = Problem633()
    check(problem.judgeSquareSum(5))
    check(!problem.judgeSquareSum(3))
}
