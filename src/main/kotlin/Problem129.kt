/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/sum-root-to-leaf-numbers/solutions/5026314/dfs-solution/
 */
class Problem129 {
    fun dfs(node: TreeNode?, pathSum: Int = 0): Int {
        if (node == null) return 0
        val nextPathSum = pathSum * 10 + node.`val`
        return if (node.left == null && node.right == null) nextPathSum
        else dfs(node.left, nextPathSum) + dfs(node.right, nextPathSum)
    }

    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root)
    }
}

fun main() {
    val root = TreeNode(1)

    val left = TreeNode(2)
    root.left = left

    val right = TreeNode(3)
    root.right = right

    val problem129 = Problem129()
    check(25 == problem129.sumNumbers(root))
}
