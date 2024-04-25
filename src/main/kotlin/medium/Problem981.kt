package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/time-based-key-value-store
 */
class Problem981 {

    class TimeMap() {
        private val store = mutableMapOf<String, MutableList<Pair<Int, String>>>()

        fun set(key: String, value: String, timestamp: Int) {
            store.putIfAbsent(key, mutableListOf())
            store.getValue(key).add(Pair(timestamp, value))
        }

        fun get(key: String, timestamp: Int): String {
            if (!store.containsKey(key)) return ""
            val pairs = store.getValue(key)
            val index = upperBound(pairs, timestamp)
            return if (index == -1) return "" else store.getValue(key)[index].second
        }

        private fun upperBound(pairs: List<Pair<Int, String>>, timestamp: Int): Int {
            var left = 0
            var right = pairs.size
            while (left < right) {
                val middle = (left + right) / 2
                if (pairs[middle].first <= timestamp) left = middle + 1
                else right = middle
            }
            check(left == right)
            return left - 1
        }
    }
}

fun main() {
    val timeMap = Problem981.TimeMap()
    timeMap.set("foo","bar",1)
    check(timeMap.get("foo",1) == "bar")
    check(timeMap.get("foo",3) == "bar")
    timeMap.set("foo","bar2",4)
    check(timeMap.get("foo",4) == "bar2")
    check(timeMap.get("foo",5) == "bar2")
}
