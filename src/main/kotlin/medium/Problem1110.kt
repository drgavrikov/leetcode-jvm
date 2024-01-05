package medium

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
class Problem1110 {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val toDelete = to_delete.toSet()
        val result = mutableListOf<TreeNode>()

        if (root != null && root.`val` !in toDelete) result.add(root)

        fun dfs(vertex: TreeNode?, parent: TreeNode?) {
            if (vertex == null) return

            dfs(vertex.left, vertex)
            dfs(vertex.right, vertex)

            if (parent?.`val` in toDelete) {
                if (parent?.left == vertex) {
                    if (vertex.`val` !in toDelete) result.add(vertex)
                    parent.left = null
                }
                if (parent?.right == vertex) {
                    if (vertex.`val` !in toDelete) result.add(vertex)
                    parent.right = null
                }
            }

            if (vertex.left?.`val` in toDelete) vertex.left = null
            if (vertex.right?.`val` in toDelete) vertex.right = null
        }

        dfs(root, null)
        return result
    }
}
