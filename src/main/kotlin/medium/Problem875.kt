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
    val problem = Problem875()
    check(problem.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8) == 4)
    check(problem.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5) == 30)
    check(problem.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6) == 23)
}