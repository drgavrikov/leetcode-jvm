/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/range-sum-of-bst
 */
class Problem938 {

    fun dfs(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        val sum = if (root.`val` in low..high) root.`val` else 0
        return sum + dfs(root.left, low, high) + dfs(root.right, low, high)
    }

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return dfs(root, low, high)
    }
}

fun main() {
    val problem = Problem938()

    runDynamicTest("test1") {
        val node3 = TreeNode(3)
        val node5 = TreeNode(5)
        val node18 = TreeNode(18)
        val node7 = TreeNode(7)
        node5.left = node3
        node5.right = node7
        val node15 = TreeNode(15)
        node15.right = node18
        val node10 = TreeNode(10)
        node10.left = node5
        node10.right = node15

        val actual = problem.rangeSumBST(node10, 7, 15)
        check(actual == 32) { "Test failed: Expected 32, actual: $actual" }
    }
}
