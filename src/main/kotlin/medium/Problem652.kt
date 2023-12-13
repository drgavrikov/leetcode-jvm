package medium

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-duplicate-subtrees/
 */
class Problem652 {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {

        val frequency = mutableMapOf<String, Int>()
        val result = mutableListOf<TreeNode?>()
        fun dfs(root: TreeNode?): String {
            if (root == null) return "";
            val treeCode = "(${dfs(root.left)})${root.`val`}(${dfs(root.right)})"

            frequency.putIfAbsent(treeCode, 0)
            frequency[treeCode] = frequency.getValue(treeCode) + 1
            if (frequency[treeCode] == 2) result.add(root)
            return treeCode
        }

        dfs(root)
        return result
    }
}
