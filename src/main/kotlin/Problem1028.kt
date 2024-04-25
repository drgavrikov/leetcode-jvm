import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 */
class Problem1028 {

    fun recoverFromPreorder(S: String): TreeNode? {
        val vertices = Stack<TreeNode>()
        var index = 0
        while (index < S.length) {
            var next = index
            while (next < S.length && S[next] == '-') next++
            val level = next - index
            index = next
            while (next < S.length && Character.isDigit(S[next])) next++
            val number = S.substring(index, next).toInt()
            index = next
            val treeNode = TreeNode(number)
            while (vertices.size > level) vertices.pop()
            if (!vertices.empty()) {
                val last = vertices.peek()
                if (last.left == null) last.left = treeNode else last.right = treeNode
            }
            vertices.push(treeNode)
        }
        return vertices[0]
    }
}

fun main() {
    val problem1028 = Problem1028()

    runDynamicTest("test1") {
        val tree = problem1028.recoverFromPreorder("1-401--349---90--88")
        check(tree?.`val` == 1) { "Test failed: Expected root value 1, actual: ${tree?.`val`}" }
        check(tree?.left?.`val` == 401) { "Test failed: Expected left child value 401, actual: ${tree?.left?.`val`}" }
        check(tree?.left?.left?.`val` == 349) { "Test failed: Expected left-left child value 349, actual: ${tree?.left?.left?.`val`}" }
    }
}
