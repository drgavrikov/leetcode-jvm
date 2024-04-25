/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/richest-customer-wealth/
 */
class Problem1672 {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        val arr = arrayOf(5)
        arr.fill(0)

        return accounts.maxOf { array -> array.sum() }
    }
}

fun main() {
    val problem1672 = Problem1672()

    runDynamicTest("test1") {
        val actual = problem1672.maximumWealth(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        )
        check(actual == 6) { "Test failed: Expected 6, actual: $actual" }
    }
}
