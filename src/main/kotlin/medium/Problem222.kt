package medium

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/count-complete-tree-nodes/
 */
class Problem222 {

    fun countNodes(root: TreeNode?): Int {
        var count = 0
        fun dfs(root: TreeNode?) {
            if (root == null) return
            count++
            dfs(root.left)
            dfs(root.right)
        }
        dfs(root)
        return count
    }
}
