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

fun main() {
    val problem1110 = Problem1110()

    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    val actual = problem1110.delNodes(node1, intArrayOf(3, 4))
    check(actual == listOf(node1, node6, node7)) { "Test 1 failed" }
}

