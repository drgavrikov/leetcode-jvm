package easy

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/range-sum-of-bst
 */
class Problem938 {

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var sum = 0
        fun dfs(node: TreeNode?) {
            if (node == null) return
            if (node.`val` in low..high) sum += node.`val`
            if (low <= node.`val`) dfs(node.left)
            if (node.`val` <= high) dfs(node.right)
        }
        dfs(root)
        return sum
    }
}


