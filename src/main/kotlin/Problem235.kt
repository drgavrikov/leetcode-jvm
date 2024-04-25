/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
class Problem235 {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var node = root
        checkNotNull(p)
        checkNotNull(q)
        while (node != null) {
            if (p.`val` < node.`val` && q.`val` < node.`val`) node = node.left
            else if (node.`val` < p.`val` && q.`val` < node.`val`) node = node.right
            else return node
        }
        return null
    }
}

fun main() {
    val problem = Problem235()
    val node = TreeNode(1)
    val root = TreeNode(2)
    root.left = node
    val actual = problem.lowestCommonAncestor(root, root, node)
    check(actual == root)
}
