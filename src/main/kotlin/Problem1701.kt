import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/average-waiting-time/solutions/5450126/simulation/
 */
class Problem1701 {

    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var freeTime = 0L
        return customers.sumOf { (arrivalTime, duration) ->
            freeTime = max(freeTime, arrivalTime.toLong()) + duration.toLong()
            freeTime - arrivalTime
        }.toDouble() / customers.size
    }
}

fun main() {
    val problem = Problem1701()
    check(problem.averageWaitingTime(arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(4, 3))) == 5.0)
}
