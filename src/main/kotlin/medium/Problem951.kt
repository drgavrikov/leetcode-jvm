package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
class Problem951 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return "$`val` left=$left $right=right"
        }
    }

    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        fun dfs(root1: TreeNode?, root2: TreeNode?): Boolean {
            if (root1 == null && root2 == null) return true
            if (root1 == null || root2 == null) return false
            if (root1.`val` != root2.`val`) return false
            if (root1.left?.`val` != root2.left?.`val` || root1.right?.`val` != root2.right?.`val`) {
                val temp = root2.left
                root2.left = root2.right
                root2.right = temp
            }
            return dfs(root1.left, root2.left) && dfs(root1.right, root2.right)
        }
        return dfs(root1, root2)
    }
}
