package medium

import TreeNode
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
