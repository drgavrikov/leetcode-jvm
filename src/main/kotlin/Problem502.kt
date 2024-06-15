import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/ipo/solutions/5318822/greedy-solution-with-heap/
 */
class Problem502 {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val projects = capital.zip(profits).sortedBy { it.first }
        val size = projects.size
        val heap = PriorityQueue<Int>(size, Collections.reverseOrder())

        var finalCapital = w
        var index = 0
        repeat(k) {
            while (index < size && projects[index].first <= finalCapital) {
                heap.add(projects[index].second)
                index++
            }
            if (heap.isEmpty()) return finalCapital
            finalCapital += heap.poll()!!
        }

        return finalCapital
    }
}

fun main() {
    val problem = Problem502()

    check(problem.findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)) == 4)
    check(problem.findMaximizedCapital(3, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)) == 6)
}
