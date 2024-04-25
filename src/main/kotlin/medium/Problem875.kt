package medium

import kotlin.math.ceil

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/koko-eating-bananas/
 */
class Problem875 {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val maxPile = piles.maxOrNull()!!

        var left = 1
        var right = maxPile + 1
        while (left < right) {
            val mid = (left + right) / 2
            val speed = piles.sumOf { ceil(it.toDouble() / mid) }
            if (speed <= h) right = mid
            else left = mid + 1
        }
        check(left == right)
        return left
    }
}

fun main() {
    val problem875 = Problem875()

    val actual1 = problem875.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8)
    check(actual1 == 4) { "Test 1 failed" }

    val actual2 = problem875.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5)
    check(actual2 == 30) { "Test 2 failed" }

    val actual3 = problem875.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6)
    check(actual3 == 23) { "Test 3 failed" }
}
