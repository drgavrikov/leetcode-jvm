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

fun main() {
    val problem222 = Problem222()

    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(3)
    val node6 = TreeNode(4)

    node1.left = node2
    node1.right = node3

    node2.left = node4
    node2.right = node5

    node3.left = node6

    runDynamicTest("test1") {
        check(problem222.countNodes(node1) == 6) { "Test 1 failed: Expected result to be 6" }
    }
}
