package medium

import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximize-distance-to-closest-person/solutions/5028776/easy-explonation-linear-solution-without-additional-memory/
 */
class Problem849 {
    fun maxDistToClosest(seats: IntArray): Int {
        var result = 0
        var prev = -1
        seats.indices.forEach { index ->
            if (seats[index] == 1) {
                result = if (prev == -1) max(result, index)
                else max(result, (index - prev) / 2)
                prev = index
            }
        }
        result = max(result, seats.size - 1 - prev)
        return result
    }
}

fun main() {
    val problem = Problem849()
    val actual = problem.maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1))
    check(actual == 2)
}
