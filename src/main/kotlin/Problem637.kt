/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
class Problem637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val levels = mutableListOf<Pair<Int, Int>>()

        fun dfs(root: TreeNode?, level: Int = 0) {
            if (root == null) return
            levels.add(Pair(level, root.`val`))
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        }
        dfs(root)

        return levels.sortedBy { it.first }
            .groupBy({ it.first }, { it.second })
            .map { it.value.average() }
            .toDoubleArray()
    }
}

fun main() {
    val problem637 = Problem637()

    val node1 = TreeNode(3)
    val node2 = TreeNode(9)
    val node3 = TreeNode(20)
    val node4 = TreeNode(15)
    val node5 = TreeNode(7)

    node1.left = node2
    node1.right = node3

    node3.left = node4
    node3.right = node5

    val actual = problem637.averageOfLevels(root = node1)
    check(actual.contentEquals(doubleArrayOf(3.0, 14.5, 11.0))) {
        "Test failed: Expected [3.0, 14.5, 11.0], actual: ${actual.contentToString()}"
    }
}
