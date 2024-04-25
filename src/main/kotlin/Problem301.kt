import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/remove-invalid-parentheses/
 */
class Problem301 {

    fun removeInvalidParentheses(s: String): List<String> {
        val queue = TreeSet<String> { o1, o2 -> if (o1.length != o2.length) -o1.length.compareTo(o2.length) else o1.compareTo(o2) }
        queue.add(s)
        val result = mutableSetOf<String>()
        while (queue.isNotEmpty()) {
            val top = queue.first()
            queue.remove(top)
            if (top.isValid()) result.add(top)
            if (result.isNotEmpty()) continue

            val balance = top.getBalance()
            top.forEachIndexed { index, char ->
                if (char == '(' && balance >= 0) queue.add(top.withoutIndex(index))
                if (char == ')' && balance <= 0) queue.add(top.withoutIndex(index))
            }
        }
        return result.toList()
    }

    private fun String.withoutIndex(index: Int) = substring(0, index) + substring(index + 1)

    private fun String.isValid(): Boolean {
        var count = 0
        forEach { char ->
            if (char == '(') count++
            if (char == ')') count--
            if (count < 0) return false
        }
        return count == 0
    }

    private fun String.getBalance() = count { it == '(' } - count { it == ')' }
}

fun main() {
    val problem = Problem301()

    val actual = problem.removeInvalidParentheses(")(()c))(")
    check(actual == listOf("(()c)", "((c))")) { actual }
}
