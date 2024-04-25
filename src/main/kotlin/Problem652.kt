/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-duplicate-subtrees/
 */
class Problem652 {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {

        val frequency = mutableMapOf<String, Int>()
        val result = mutableListOf<TreeNode?>()
        fun dfs(root: TreeNode?): String {
            if (root == null) return ""
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

fun main() {
    val problem652 = Problem652()

    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(2)
    val node4 = TreeNode(3)
    val node5 = TreeNode(3)

    node1.left = node2
    node1.right = node3

    node2.left = node4
    node3.left = node5

    val actual = problem652.findDuplicateSubtrees(node1)
    check(actual.toSet() == setOf(node3, node5)) { "Test 1 failed" }
}
