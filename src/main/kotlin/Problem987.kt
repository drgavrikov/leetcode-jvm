import java.util.TreeMap

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
class Problem987 {

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {

        val columnRowValues = TreeMap<Int, TreeMap<Int, MutableList<Int>>>()

        fun dfs(root: TreeNode?, row: Int = 0, column: Int = 0) {
            if (root == null) return
            columnRowValues.putIfAbsent(column, TreeMap())
            columnRowValues.getValue(column).putIfAbsent(row, mutableListOf())
            columnRowValues.getValue(column).getValue(row).add(root.`val`)
            dfs(root.left, row + 1, column - 1)
            dfs(root.right, row + 1, column + 1)
        }
        dfs(root)

        return columnRowValues.values
            .map { rowValues ->
                rowValues.values.flatMap { it.sorted() }.toList()
            }.toList()
    }
}

fun main() {
    val problem987 = Problem987()

    val root1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    val actual1 = problem987.verticalTraversal(root1)
    check(
        actual1 == listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7))
    ) { "Test failed: Expected [[9], [3, 15], [20], [7]], actual: $actual1" }

    val root2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            left = TreeNode(6)
            right = TreeNode(7)
        }
    }
    val actual2 = problem987.verticalTraversal(root2)
    check(actual2 == listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7))) {
        "Test failed: Expected [[4], [2], [1, 5, 6], [3], [7]], actual: $actual2"
    }
}

