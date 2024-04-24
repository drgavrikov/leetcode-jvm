package hard

import TreeNode
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
class Problem124 {

    var result = Int.MIN_VALUE

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0
        val leftPath = max(dfs(node.left), 0)
        val rightPath = max(dfs(node.right), 0)
        result = max(result, leftPath + rightPath + node.`val`)
        return max(leftPath, rightPath) + node.`val`
    }

    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return result
    }
}

fun main() {
    val problem = Problem124()
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    node1.left = node2
    node1.right = node3
    check(problem.maxPathSum(node1) == 6)
}
