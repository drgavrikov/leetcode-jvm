import java.util.Collections
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-cost-to-hire-k-workers/solutions/5322437/solution-with-sort-and-heap/
 */
class Problem857 {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
            val wageToQualities = wage
            .zip(quality)
            .map { (workerWage, workerQuality) -> Pair(workerWage.toDouble() / workerQuality.toDouble(), workerQuality) }
            .sortedBy { it.first }

        var qualitySum = 0
        val heap = PriorityQueue<Int>(k, Collections.reverseOrder())
        wageToQualities.take(k).forEach { wageToQuality ->
            qualitySum += wageToQuality.second
            heap.add(wageToQuality.second)
        }

        var mincost = qualitySum * wageToQualities[k - 1].first
        wageToQualities.drop(k).forEach { wageToQuality ->
            qualitySum = qualitySum - heap.poll()!! + wageToQuality.second
            heap.add(wageToQuality.second)
            mincost = min(mincost, qualitySum * wageToQuality.first)
        }
        return mincost
    }
}

fun main() {
    val problem857 = Problem857()

    val actual1 = problem857.mincostToHireWorkers(
        intArrayOf(10, 20, 5),
        intArrayOf(70, 50, 30),
        2
    )
    check(actual1 == 105.0) { "Test failed: Expected 105.0, actual: $actual1" }

    val actual2 = problem857.mincostToHireWorkers(
        intArrayOf(3, 1, 10, 10, 1),
        intArrayOf(4, 8, 2, 2, 7),
        3
    )
    check(abs(actual2 - 30.66667) < 1e-5) { "Test failed: Expected 30.66667, actual: $actual2" }
}
