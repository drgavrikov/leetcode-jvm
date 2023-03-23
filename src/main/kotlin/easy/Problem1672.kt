package easy

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
