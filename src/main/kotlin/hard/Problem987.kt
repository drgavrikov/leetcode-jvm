package hard

import TreeNode
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

    runDynamicTest("test1") {
        val root = TreeNode(3)

        root.left = TreeNode(9)
        root.right = TreeNode(20)

        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)

        val actual = problem987.verticalTraversal(root)
        check(
            actual == listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7))
        ) { "Test failed: Expected [[9], [3, 15], [20], [7]], actual: $actual" }
    }

    runDynamicTest("test2") {
        val root = TreeNode(1)

        root.left = TreeNode(2)
        root.right = TreeNode(3)

        root.left!!.left = TreeNode(4)
        root.left!!.right = TreeNode(5)
        root.right!!.left = TreeNode(6)
        root.right!!.right = TreeNode(7)

        val actual = problem987.verticalTraversal(root)
        check(
            actual == listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7))
        ) { "Test failed: Expected [[4], [2], [1, 5, 6], [3], [7]], actual: $actual" }
    }
}
