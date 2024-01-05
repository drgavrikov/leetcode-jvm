package medium

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class Problem114 {
    fun flatten(root: TreeNode?): Unit {
        val preOrderNodes = mutableListOf<TreeNode>()

        fun dfs(root: TreeNode?) {
            if (root == null) return
            preOrderNodes.add(root)
            dfs(root.left)
            dfs(root.right)
        }

        dfs(root)
        preOrderNodes.forEach { node ->
            node.left = null
            node.right = null
        }
        preOrderNodes.zipWithNext().forEach { (prev, next) ->
            prev.right = next
        }
    }
}
