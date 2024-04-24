package medium

import java.util.Stack

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/basic-calculator-ii/
 */
class Problem227 {

    fun calculate(s: String): Int {
        val stack = Stack<Int>()

        fun makeOperation(operation: Char, current: Int) {
            when (operation) {
                '+' -> stack.add(current)
                '-' -> stack.add(-current)
                '*' -> stack.add(stack.pop()!! * current)
                '/' -> stack.add(stack.pop()!! / current)
                else -> throw Exception("Unknown operation")
            }
        }

        var operation = '+'
        var current = 0

        s.filter { it != ' ' }.forEach { c ->
            when {
                c.isDigit() -> current = current * 10 + c.digitToInt()
                c in setOf('+', '-', '*', '/') -> {
                    makeOperation(operation, current)
                    operation = c
                    current = 0
                }

                else -> throw Exception("Unknown character")
            }
        }
        makeOperation(operation, current)
        return stack.sum()
    }
}

fun main() {
    val problem227 = Problem227()
    check(problem227.calculate("3+2*2") == 7)
    check(problem227.calculate(" 3+5 / 2 ") == 5)
}