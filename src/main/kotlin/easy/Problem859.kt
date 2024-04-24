package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/buddy-strings/
 */
class Problem859 {
    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        val diffIndices = (s.indices).filter { index -> s[index] != goal[index] }
        if (diffIndices.isEmpty())
            return s.groupingBy { it }.eachCount().size != s.length
        if (diffIndices.size == 2) {
            val index1 = diffIndices[0]
            val index2 = diffIndices[1]
            return (s[index1] == goal[index2] && s[index2] == goal[index1])
        }
        return false
    }
}

fun main() {
    val problem859 = Problem859()

    runDynamicTest("test1") {
        val actual = problem859.buddyStrings("aaa", "aaa")
        check(actual) { "Test failed: Expected true, actual: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem859.buddyStrings("abc", "abc")
        check(!actual) { "Test failed: Expected false, actual: $actual" }
    }
}
