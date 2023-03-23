package hard

import TreeNode
import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 */
class Problem1028 {

    fun recoverFromPreorder(S: String): TreeNode? {
        val vertices = Stack<TreeNode>()
        var index = 0
        while (index < S.length) {
            var next = index
            while (next < S.length && S[next] == '-') next++
            val level = next - index
            index = next
            while (next < S.length && Character.isDigit(S[next])) next++
            val number = S.substring(index, next).toInt()
            index = next
            val treeNode = TreeNode(number)
            while (vertices.size > level) vertices.pop()
            if (!vertices.empty()) {
                val last = vertices.peek()
                if (last.left == null) last.left = treeNode else last.right = treeNode
            }
            vertices.push(treeNode)
        }
        return vertices[0]
    }
}
