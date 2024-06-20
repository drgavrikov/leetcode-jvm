/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/generate-parentheses/solutions/5342674/generation-of-all-bracket-sequences-based-on-obtaining-the-next-one-without-recursion/
 */
class Problem22 {

    fun generateParenthesis(n: Int): List<String> {
        val parentheses = CharArray(n * 2) { if (it < n) '(' else ')' }
        val result = mutableListOf<String>()

        do {
            result.add(parentheses.concatToString())
        } while (nextPermutation(parentheses))
        return result
    }

    private fun nextPermutation(parentheses: CharArray): Boolean {
        val size = parentheses.size / 2
        var openedCount = size
        var closedCount = size
        for (index in parentheses.size - 1 downTo 0) {
            if (parentheses[index] == ')') closedCount-- else openedCount--

            if (parentheses[index] == '(' && openedCount > closedCount) {
                parentheses[index] = ')'
                val toIndex = (index + 1) + (size - openedCount)
                parentheses.fill('(', index + 1, toIndex)
                parentheses.fill(')', toIndex)
                return true
            }
        }
        return false
    }
}

fun main() {
    val problem = Problem22()

    //problem.nextPermutation("(())(())".toCharArray())

    val excepted = listOf("((()))", "(()())", "(())()", "()(())", "()()()")
    check(problem.generateParenthesis(3) == excepted)
}
