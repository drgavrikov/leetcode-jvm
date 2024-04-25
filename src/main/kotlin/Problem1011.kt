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

fun main() {
    val problem1011 = Problem1011()

    val actual1 = problem1011.shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5)
    check(actual1 == 15) { "Test 1 failed" }

    val actual2 = problem1011.shipWithinDays(intArrayOf(3, 2, 2, 4, 1, 4), 3)
    check(actual2 == 6) { "Test 2 failed" }

    val actual3 = problem1011.shipWithinDays(intArrayOf(1, 2, 3, 1, 1), 4)
    check(actual3 == 3) { "Test 3 failed" }
}

