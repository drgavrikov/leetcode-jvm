package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/generate-parentheses/
 */
class Problem22 {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        fun brute(brackets: String = "", opened: Int = 0, closed: Int = 0) {
            if (brackets.length == 2 * n) {
                result.add(brackets)
                return
            }
            if (opened < n) brute("$brackets(", opened + 1, closed)
            if (opened > closed) brute("$brackets)", opened, closed + 1)
        }
        brute()
        return result.sorted()
    }
}
