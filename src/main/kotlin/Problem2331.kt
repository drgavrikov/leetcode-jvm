/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/evaluate-boolean-binary-tree/solutions/5292033/dfs-solution/
 */
class Problem2331 {
    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) return true
        return when (root.`val`) {
            0 -> return false
            1 -> return true
            2 -> return evaluateTree(root.left) || evaluateTree(root.right)
            3 -> return evaluateTree(root.left) && evaluateTree(root.right)
            else -> throw Exception("")
        }
    }
}

fun main() {
    val problem = Problem2331()

    val root = TreeNode(2,
        TreeNode(1),
        TreeNode(3,
            TreeNode(0),
            TreeNode(1)
        )
    )
    check(problem.evaluateTree(root))
}
