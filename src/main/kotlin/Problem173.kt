import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/binary-search-tree-iterator/
 */
class Problem173 {
    inner class BSTIterator(root: TreeNode?) {

        private val stack = Stack<TreeNode?>()

        init {
            addNext(root)
        }

        fun next(): Int {
            val result = stack.pop()
            addNext(result?.right)
            return result!!.`val`
        }

        fun hasNext(): Boolean {
            return !stack.isEmpty()
        }

        private fun addNext(root: TreeNode?) {
            var current = root
            while (current != null) {
                stack.add(current)
                current = current.left
            }
        }
    }
}

fun main() {
    val problem = Problem173()

    val node9 = TreeNode(9)
    val node20 = TreeNode(20)
    val node15 = TreeNode(15)
    val node7 = TreeNode(7)
    val node3 = TreeNode(3)

    node15.left = node9
    node15.right = node20
    node7.left = node3
    node7.right = node15

    val iterator = problem.BSTIterator(node7)
    check(iterator.next() == 3) { "Test 1 failed: Expected next value to be 3" }
    check(iterator.next() == 7) { "Test 1 failed: Expected next value to be 7" }
    check(iterator.hasNext()) { "Test 1 failed: Expected hasNext to be true" }
    check(iterator.next() == 9) { "Test 1 failed: Expected next value to be 9" }
    check(iterator.hasNext()) { "Test 1 failed: Expected hasNext to be true" }
    check(iterator.next() == 15) { "Test 1 failed: Expected next value to be 15" }
    check(iterator.hasNext()) { "Test 1 failed: Expected hasNext to be true" }
    check(iterator.next() == 20) { "Test 1 failed: Expected next value to be 20" }
    check(!iterator.hasNext()) { "Test 1 failed: Expected hasNext to be false" }
}
