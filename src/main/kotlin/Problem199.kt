/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class Problem199 {
    private fun dfs(node: TreeNode?, rightSide: MutableList<Int>, depht: Int) {
        if (node == null) return
        if (rightSide.size == depht) rightSide.add(node.`val`)
        dfs(node.right, rightSide, depht + 1)
        dfs(node.left, rightSide, depht + 1)
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        dfs(root, result, 0)
        return result.toList()
    }
}

fun main() {
    val left = TreeNode(2)
    val root = TreeNode(1)
    root.left = left
    val problem = Problem199()
    val actual = problem.rightSideView(root)
    check(actual == listOf(1, 2))
}
