import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-valid-parentheses/solutions/5024031/linear-solution-without-additional-memory/
 */
class Problem32 {

    fun longestValidParentheses(s: String): Int {
        var result = 0

        var openedCount = 0
        var closedCount = 0

        var reversedOpenedCount = 0
        var reversedClosedCount = 0

        s.indices.forEach { index ->
            if (s[index] == '(') openedCount++
            else closedCount++
            if (openedCount == closedCount) result = max(result, openedCount * 2)
            if (closedCount > openedCount) {
                openedCount = 0
                closedCount = 0
            }

            if (s[s.length - index - 1] == '(') reversedOpenedCount++
            else reversedClosedCount++
            if (reversedOpenedCount == reversedClosedCount) result = max(result, reversedClosedCount * 2)
            if (reversedOpenedCount > reversedClosedCount) {
                reversedOpenedCount = 0
                reversedClosedCount = 0
            }
        }
        return result
    }
}

fun main() {
    val problem32 = Problem32()
    check(4 == problem32.longestValidParentheses("((()()"))
    check(4 == problem32.longestValidParentheses("))()()"))
}
