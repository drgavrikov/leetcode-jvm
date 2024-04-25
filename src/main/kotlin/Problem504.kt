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

    runDynamicTest("test1") {
        val actual = problem.convertToBase7(100)
        check(actual == "202") { "Test failed: Expected '202', actual: '$actual'" }
    }

    runDynamicTest("test2") {
        val actual = problem.convertToBase7(-7)
        check(actual == "-10") { "Test failed: Expected '-10', actual: '$actual'" }
    }

    runDynamicTest("test3") {
        val actual = problem.convertToBase7(6)
        check(actual == "6") { "Test failed: Expected '6', actual: '$actual'" }
    }
}
