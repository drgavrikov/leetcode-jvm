import java.util.*

class Problem1028 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return "[$`val` left=${left} right=${right}]"
        }
    }

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
