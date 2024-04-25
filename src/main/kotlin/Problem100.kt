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

    val p1 = TreeNode(1)
    p1.left = TreeNode(2)
    p1.right = TreeNode(3)

    val q1 = TreeNode(1)
    q1.left = TreeNode(2)
    q1.right = TreeNode(3)

    val actual1 = problem100.isSameTree(p1, q1)
    check(actual1) { "Test failed: Expected true, actual: $actual1" }

    val p2 = TreeNode(1)
    p2.left = TreeNode(2)

    val q2 = TreeNode(1)
    q2.right = TreeNode(2)

    val actual2 = problem100.isSameTree(p2, q2)
    check(!actual2) { "Test failed: Expected false, actual: $actual2" }
}
