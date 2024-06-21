/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
class Problem1552 {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        var low = 1
        var high = ((position.last() - position.first()).toDouble() / (m - 1)).toInt()

        var result = 0
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (checkDistance(position, mid, m)) {
                result = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return result
    }

    private fun checkDistance(position: IntArray, distance: Int, m: Int): Boolean {
        var count = 1

        var previousPosition = position.first()
        position.forEach { currentPosition ->
            if (currentPosition - previousPosition >= distance) {
                count++
                previousPosition = currentPosition
            }
            if (count >= m) return true
        }
        return count >= m
    }
}

fun main() {
    val problem = Problem1552()
    check(problem.maxDistance(intArrayOf(1, 2, 3, 4, 7), 3) == 3)
}
