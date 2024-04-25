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

    runDynamicTest("test1") {
        val actual = problem326.isPowerOfThree(3)
        check(actual) { "Test failed: Expected true, actual: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem326.isPowerOfThree(-27)
        check(!actual) { "Test failed: Expected false, actual: $actual" }
    }

    runDynamicTest("test3") {
        val actual = problem326.isPowerOfThree(15)
        check(!actual) { "Test failed: Expected false, actual: $actual" }
    }

    runDynamicTest("test4") {
        val actual = problem326.isPowerOfThree(0)
        check(!actual) { "Test failed: Expected false, actual: $actual" }
    }
}
