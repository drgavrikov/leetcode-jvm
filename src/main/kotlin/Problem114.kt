/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class Problem114 {
    fun flatten(root: TreeNode?) {
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

fun main() {
    val problem = Problem114()

    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)

    node2.left = node3
    node2.right = node4
    node5.right = node6
    node1.left = node2
    node1.right = node5

    problem.flatten(node1)
    val expected = listOf(1, 2, 3, 4, 5, 6)
    val actual = mutableListOf<Int>()
    var current: TreeNode? = node1
    while (current != null) {
        actual.add(current.`val`)
        current = current.right
    }
    check(actual == expected) { "Test 1 failed: Expected $expected, but got $actual" }
}
