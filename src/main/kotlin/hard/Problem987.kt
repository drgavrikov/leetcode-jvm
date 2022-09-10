package hard

import java.util.TreeMap

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
class Problem987 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

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
