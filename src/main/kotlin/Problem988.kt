/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/smallest-string-starting-from-leaf/solutions/5036555/dfs-solution/
 */
class Problem988 {

    private fun dfs(node: TreeNode?, chars: MutableList<Char>): String {
        if (node == null) return ('z' + 1).toString()
        chars.add('a' + node.`val`)
        val result = if (node.left == null && node.right == null) {
            chars.reversed().joinToString("")
        } else {
            val left = dfs(node.left, chars)
            val right = dfs(node.right, chars)
            if (left < right) left else right
        }
        chars.removeLast()
        return result
    }

    fun smallestFromLeaf(root: TreeNode?): String {
        return dfs(root, mutableListOf())
    }
}

fun main() {
    val problem988 = Problem988()
    val node0 = TreeNode(0)
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)

    node0.left = node1
    node0.right = node2

    node1.left = node3
    node1.right = node4

    node2.right = node5
    node2.right = node6

    check("dba" == problem988.smallestFromLeaf(node0))
}
