/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/design-hit-counter/description/
 */
class Problem356 {
    fun isReflected(points: Array<IntArray>): Boolean {
        val coordinates = points
            .groupBy({ it[0] }, { it[1] })
            .mapValues { (_, ys) -> ys.toMutableSet() }

        val min = coordinates.keys.minOrNull()!!
        val max = coordinates.keys.maxOrNull()!!
        val middle = (min + max * 1.0) / 2

        return points.all { (x, y) ->
            val reflectedX = (middle - (x - middle)).toInt()
            reflectedX in coordinates && y in coordinates.getValue(reflectedX)
        }
    }
}

fun main() {
    val problem = Problem356()
    check(problem.isReflected(arrayOf(intArrayOf(1, 1), intArrayOf(-1, 1))))
    check(!problem.isReflected(arrayOf(intArrayOf(1, 1), intArrayOf(-1, -1))))
    check(problem.isReflected(arrayOf(intArrayOf(-5, 1), intArrayOf(5, 1), intArrayOf(5, 1))))
}
