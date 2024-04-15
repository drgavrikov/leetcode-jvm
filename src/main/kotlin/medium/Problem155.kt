package medium

import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/min-stack/solutions/4599315/kotlin-solution-with-second-stack/
 */
class Problem155 {
    inner class MinStack() {

        private val stack = Stack<Int>()
        private val minElements = Stack<Int>()

        fun push(`val`: Int) {
            stack.push(`val`)
            if (minElements.empty() || minElements.peek() > `val`) minElements.push(`val`)
        }

        fun pop() {
            if (stack.peek() == minElements.peek()) minElements.pop()
            stack.pop()
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minElements.peek()
        }

    }
}

fun main() {
    val problem155 = Problem155()
    val stack = problem155.MinStack()
    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    check(-3 == stack.getMin())
    stack.pop()
    check(0 == stack.top())
    check(-2 == stack.getMin())
}
