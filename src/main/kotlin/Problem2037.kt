import kotlin.math.abs

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/solutions/5309691/greedy-sorting-solution/
 */
class Problem2037 {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        return seats.sorted().zip(students.sorted()).sumOf { (seat, student) -> abs(seat - student) }
    }
}

fun main() {
    val problem = Problem2037()
    check(problem.minMovesToSeat(intArrayOf(3, 1, 5), intArrayOf(2, 7, 4)) == 4)
}
