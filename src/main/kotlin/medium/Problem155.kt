package medium

import java.util.*
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/min-stack/
 */
class Problem155 {
    inner class MinStack() {

        private val stack = Stack<Int>()
        private val minElements = Stack<Int>()

        fun push(`val`: Int) {
            stack.push(`val`)
            if (minElements.empty()) minElements.push(`val`)
            else minElements.push(min(`val`, minElements.peek()))
        }

        fun pop() {
            stack.pop()
            minElements.pop()
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minElements.peek()
        }

    }
}
