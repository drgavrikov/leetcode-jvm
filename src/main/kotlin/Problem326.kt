/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/power-of-three/
 */
class Problem326 {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false
        var x = n
        while (x % 3 == 0) x /= 3
        return x == 1
    }
}

fun main() {
    val problem326 = Problem326()

    val actual1 = problem326.isPowerOfThree(3)
    check(actual1) { "Test failed: Expected true, actual: $actual1" }

    val actual2 = problem326.isPowerOfThree(-27)
    check(!actual2) { "Test failed: Expected false, actual: $actual2" }

    val actual3 = problem326.isPowerOfThree(15)
    check(!actual3) { "Test failed: Expected false, actual: $actual3" }

    val actual4 = problem326.isPowerOfThree(0)
    check(!actual4) { "Test failed: Expected false, actual: $actual4" }
}

