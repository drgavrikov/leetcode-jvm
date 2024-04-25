/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/design-hit-counter/description/
 */
class Problem362 {

    class HitCounter() {

        data class TimestampCount(var timestamp: Int = 0, var count: Int = 0)

        private val counts = Array(FIVE_MINUTES_SECONDS) { TimestampCount() }

        fun hit(timestamp: Int) {
            val mod = timestamp % FIVE_MINUTES_SECONDS
            if (counts[mod].timestamp != timestamp) counts[mod].count = 0
            counts[mod].timestamp = timestamp
            counts[mod].count++
        }

        fun getHits(timestamp: Int): Int {
            return counts
                .filter { it.timestamp > timestamp - FIVE_MINUTES_SECONDS }
                .sumOf { it.count }
        }

    }

    companion object {
        private const val FIVE_MINUTES_SECONDS = 300
    }
}

fun main() {
    val counter = Problem362.HitCounter()
    counter.hit(1)
    counter.hit(2)
    counter.hit(3)
    counter.hit(4)
    check(counter.getHits(5) == 4)

    counter.hit(300)
    counter.hit(300)
    counter.hit(301)
    check(counter.getHits(302) == 5)
}
