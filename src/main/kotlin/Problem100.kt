/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/same-tree/
 */
class Problem100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        fun dfs(p: TreeNode?, q: TreeNode?): Boolean {
            if (p == null && q == null) return true
            if (p == null || q == null) return false
            if (p.`val` != q.`val`) return false
            return dfs(p.left, q.left) && dfs(p.right, q.right)
        }
        return dfs(p, q)
    }
}

fun main() {
    val problem100 = Problem100()

    runDynamicTest("test1") {
        val p = TreeNode(1)
        p.left = TreeNode(2)
        p.right = TreeNode(3)

        val q = TreeNode(1)
        q.left = TreeNode(2)
        q.right = TreeNode(3)

        val actual = problem100.isSameTree(p, q)
        check(actual) { "Test failed: Expected true, actual: $actual" }
    }

    runDynamicTest("test2") {
        val p = TreeNode(1)
        p.left = TreeNode(2)

        val q = TreeNode(1)
        q.right = TreeNode(2)

        val actual = problem100.isSameTree(p, q)
        check(!actual) { "Test failed: Expected false, actual: $actual" }
    }
}
