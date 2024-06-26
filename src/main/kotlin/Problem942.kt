/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/di-string-match/description/
 */
class Problem942 {

    fun diStringMatch(s: String): IntArray {
        var i = 0
        var d = s.length
        return (s.map { char -> if (char == 'I') i++ else d-- } + i).toIntArray()
    }
}

fun main() {
    val problem = Problem942()

    val actual1 = problem.diStringMatch("IDID")
    check(actual1.contentEquals(intArrayOf(0, 4, 1, 3, 2))) { "Test failed: Expected [0, 4, 1, 3, 2], actual: ${actual1.contentToString()}" }

    val actual2 = problem.diStringMatch("III")
    check(actual2.contentEquals(intArrayOf(0, 1, 2, 3))) { "Test failed: Expected [0, 1, 2, 3], actual: ${actual2.contentToString()}" }
}
