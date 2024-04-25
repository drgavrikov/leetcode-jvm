import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/valid-parentheses/description/
 */
class Problem20 {
    fun isValid(s: String): Boolean {
        val parentheses = Stack<Char>()
        s.forEach { char ->
            if (char in brackets.values) parentheses.add(char)
            else if (parentheses.isEmpty() || parentheses.pop() != brackets.getValue(char)) return false
        }
        return parentheses.isEmpty()
    }

    companion object {
        val brackets = mapOf(')' to '(', ']' to '[', '}' to '{')
    }
}

fun main() {
    val problem = Problem20()

    val actual1 = problem.isValid("(){}[]")
    check(actual1) { "Test failed: Expected true, actual: $actual1" }

    val actual2 = problem.isValid("([)]")
    check(!actual2) { "Test failed: Expected false, actual: $actual2" }
}
