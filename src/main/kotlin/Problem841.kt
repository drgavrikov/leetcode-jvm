/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/keys-and-rooms/solutions/5028904/dfs-easy-solution/
 */
class Problem841 {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val used = BooleanArray(n) { false }

        fun dfs(room: Int) {
            if (used[room]) return
            used[room] = true
            rooms[room].forEach { next -> dfs(next) }
        }
        dfs(0)
        return used.all { it }
    }
}

fun main() {
    val problem841 = Problem841()
    check(!problem841.canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))
}