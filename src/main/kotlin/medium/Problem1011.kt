package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
class Problem1011 {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var minCapacity = weights.maxOrNull()!!
        var maxCapacity = weights.sum()
        while (minCapacity < maxCapacity) {
            val middle = (minCapacity + maxCapacity) / 2
            val daysForMiddle = calcDaysForCapacity(weights, middle)
            if (daysForMiddle > days) minCapacity = middle + 1
            else maxCapacity = middle
        }
        return minCapacity
    }

    private fun calcDaysForCapacity(weights: IntArray, capacity: Int): Int {
        var days = 0
        var current = 0
        weights.forEach { weight ->
            if (current + weight <= capacity) current += weight
            else {
                current = weight
                days++
            }
        }
        return days + 1
    }
}
