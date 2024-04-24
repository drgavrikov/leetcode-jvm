package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
class Problem150 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = mutableListOf<Int>()
        tokens.forEach { it ->
            when (it) {
                "+" -> {
                    val value1 = stack.removeLast()
                    val value2 = stack.removeLast()
                    stack.add(value1 + value2)
                }

                "-" -> {
                    val value1 = stack.removeLast()
                    val value2 = stack.removeLast()
                    stack.add(value2 - value1)
                }

                "*" -> {
                    val value1 = stack.removeLast()
                    val value2 = stack.removeLast()
                    stack.add(value1 * value2)
                }

                "/" -> {
                    val value1 = stack.removeLast()
                    val value2 = stack.removeLast()
                    stack.add((value2 / value1))
                }

                else -> stack.add(it.toInt())
            }
        }
        return stack.last()
    }
}

fun main() {
    val problem = Problem150()
    check(problem.evalRPN(arrayOf("2", "1", "+", "3", "*")) == 9)
    check(problem.evalRPN(arrayOf("4","13","5","/","+")) == 6)
}