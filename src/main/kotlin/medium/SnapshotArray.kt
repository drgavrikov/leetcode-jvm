package medium


/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/snapshot-array/
 */
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
