/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/solutions/5369530/reverse-in-order-traversal-solution/
 */
class Problem1038 {
    fun bstToGstDfs(node: TreeNode?, greaterSum: IntArray = intArrayOf(0)) {
        if (node == null) return
        bstToGstDfs(node.right, greaterSum)
        node.`val` += greaterSum.first()
        greaterSum[0] = node.`val`
        bstToGstDfs(node.left, greaterSum)
    }

    fun bstToGst(root: TreeNode?): TreeNode? {
        bstToGstDfs(root)
        return root
    }
}

fun main() {
    val problem = Problem1038()

    val root = TreeNode(0, null, TreeNode(1, null, null))
    problem.bstToGst(root)
    check(root.`val` == 1)
}
