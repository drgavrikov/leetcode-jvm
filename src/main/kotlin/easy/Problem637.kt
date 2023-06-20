package easy

import TreeNode

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
