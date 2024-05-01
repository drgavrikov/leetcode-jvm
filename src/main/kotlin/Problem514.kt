import kotlin.math.abs
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/freedom-trail/solutions/5083589/top-down-dynamic-programming-with-only-additional-linear-space/
 */
class Problem514 {

    private fun calcDist(from: Int, to: Int, length: Int): Int {
        val directDist = abs(from - to)
        return min(directDist, length - directDist)
    }

    fun findRotateSteps(ring: String, key: String): Int {
        var prev = IntArray(ring.length) { Int.MAX_VALUE / 2 }
        for (ringIndex in ring.indices) {
            if (key[0] == ring[ringIndex]) {
                prev[ringIndex] = calcDist(0, ringIndex, ring.length) + 1
            }
        }
        for (keyIndex in 1 until key.length) {
            val next = IntArray(ring.length) { Int.MAX_VALUE / 2 }
            for (ringIndex in ring.indices) {
                if (key[keyIndex] != ring[ringIndex]) continue
                for (prevRingIndex in ring.indices) {
                    next[ringIndex] = min(next[ringIndex], calcDist(prevRingIndex, ringIndex, ring.length))
                }
            }
            prev = next.copyOf()
        }
        return prev.minOf { it }
    }
}

fun main() {
    val problem514 = Problem514()
    val actual = problem514.findRotateSteps("godding", "godding")
    check(actual == 13)
}
