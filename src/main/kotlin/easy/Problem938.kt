package easy

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/range-sum-of-bst
 */
class Problem938 {

    fun dfs(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        val sum = if (root.`val` in low..high) root.`val` else 0
        return sum + dfs(root.left, low, high) + dfs(root.right, low, high)
    }

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return dfs(root, low, high)
    }
}


