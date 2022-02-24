package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/count-complete-tree-nodes/
 */
class Problem222 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

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
