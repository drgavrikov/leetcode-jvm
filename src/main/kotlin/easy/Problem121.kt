package easy

import kotlin.math.max


/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
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
