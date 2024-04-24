package easy

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
class Problem121 {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var minPrice = prices.first()
        prices.forEach { price ->
            if (price < minPrice) minPrice = price
            result = max(result, price - minPrice)
        }
        return result
    }
}

fun main() {
    val problem = Problem121()

    runDynamicTest("test1") {
        val actual = problem.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
        check(actual == 5) { "Test failed: Expected 5, actual: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem.maxProfit(intArrayOf(7, 6, 4, 3, 1))
        check(actual == 0) { "Test failed: Expected 0, actual: $actual" }
    }
}
