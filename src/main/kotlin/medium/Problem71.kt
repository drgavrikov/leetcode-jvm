package medium

import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/simplify-path/solutions/5036279/stack-solution/
 */
class Problem71 {

    fun simplifyPath(path: String): String {
        val parts = path.split("/")
            .filter { it.isNotEmpty() }
            .toList()
        val stack = Stack<String>()
        for (dir in parts) {
            if (dir == ".") continue
            if (dir == "..") {
                if (stack.isNotEmpty()) stack.pop()
            } else stack.push(dir)
        }
        return "/" + stack.joinToString(separator = "/")
    }
}

fun main() {
    val problem = Problem71()
    check(problem.simplifyPath("/../").contentEquals("/"))
    check(problem.simplifyPath("/home//foo/").contentEquals("/home/foo"))
}
