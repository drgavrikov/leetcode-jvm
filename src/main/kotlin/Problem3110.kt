import kotlin.math.abs

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/score-of-a-string/solutions/5242625/one-line-solution/
 */
class Problem3110 {
    fun scoreOfString(s: String): Int {
        return s.zipWithNext { prev, next -> abs(prev - next)  }.sum()
    }
}

fun main() {
    val problem = Problem3110()

    val actual1 = problem.scoreOfString("")
    check(actual1 == 12) { "Test 1 failed" }
}

