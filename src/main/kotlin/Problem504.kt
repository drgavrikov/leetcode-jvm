/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/base-7/
 */
class Problem504 {
    fun convertToBase7(num: Int): String {
        var current = num
        var result = 0
        var pow = 1
        while (current != 0) {
            val tmp = current % 7
            result += tmp * pow
            pow *= 10
            current /= 7
        }
        return result.toString()
    }
}

fun main() {
    val problem = Problem504()

    val actual1 = problem.convertToBase7(100)
    check(actual1 == "202") { "Test failed: Expected '202', actual: '$actual1'" }

    val actual2 = problem.convertToBase7(-7)
    check(actual2 == "-10") { "Test failed: Expected '-10', actual: '$actual2'" }

    val actual3 = problem.convertToBase7(6)
    check(actual3 == "6") { "Test failed: Expected '6', actual: '$actual3'" }
}
