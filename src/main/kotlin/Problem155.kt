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
    val minStack = Problem155().MinStack()

    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    check(minStack.getMin() == -3) { "Test 1 failed: Expected minimum value to be -3" }
    minStack.pop()
    check(minStack.top() == 0) { "Test 1 failed: Expected top value to be 0" }
    check(minStack.getMin() == -2) { "Test 1 failed: Expected minimum value to be -2" }
}
