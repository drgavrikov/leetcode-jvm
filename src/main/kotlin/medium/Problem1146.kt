package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/snapshot-array
 */
class Problem1146 {
    class SnapshotArray(length: Int) {

        private var snapId = 0
        private val snaps = Array(length) { mutableMapOf<Int, Int>() }

        fun set(index: Int, `val`: Int) {
            snaps[index][snapId] = `val`
        }

        fun snap(): Int = snapId++

        fun get(index: Int, snap_id: Int): Int {
            var current = snap_id
            while (current >= 0 && !snaps[index].containsKey(current)) current--
            return if (current == -1) 0 else snaps[index].getValue(current)
        }
    }
}

fun main() {
    val snapshotArray = Problem1146.SnapshotArray(3)
    snapshotArray.set(0, 5)
    check(snapshotArray.snap() == 0) { "Test 1 failed" }
    snapshotArray.set(0, 6)
    check(snapshotArray.snap() == 1) { "Test 1 failed" }
    snapshotArray.set(1, 7)
    check(snapshotArray.get(0, 0) == 5) { "Test 1 failed" }
    check(snapshotArray.snap() == 2) { "Test 1 failed" }
    snapshotArray.set(2, 10)
    check(snapshotArray.get(1, 2) == 7) { "Test 1 failed" }
    check(snapshotArray.snap() == 3) { "Test 1 failed" }
}


