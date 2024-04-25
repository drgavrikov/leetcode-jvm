import java.util.LinkedList
import java.util.Queue

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/add-one-row-to-tree/solutions/5033920/bfs-solution/
 */
class Problem623 {

    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 1) {
            val newNode = TreeNode(`val`)
            newNode.left = root
            return newNode
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        repeat( depth - 2) {
            val nextLevelNodes = mutableListOf<TreeNode>()
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                node.left?.let { nextLevelNodes.add(node.left!!) }
                node.right?.let { nextLevelNodes.add(node.right!!) }
            }
            queue.addAll(nextLevelNodes)
        }
        queue.forEach { node ->
            node.left?.let {
                val newNode = TreeNode(`val`)
                newNode.left = it
                node.left = newNode
            }
            node.right?.let {
                val newNode = TreeNode(`val`)
                newNode.right = it
                node.right = newNode
            }
        }
        return root
    }
}

fun main() {
    val root = TreeNode(4)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node1 = TreeNode(1)

    root.left = node2
    node2.left = node3
    node1.right = node1

    val problem623 = Problem623()
    problem623.addOneRow(root, 1, 3)
    check(node2.left?.`val` == 1)
}
