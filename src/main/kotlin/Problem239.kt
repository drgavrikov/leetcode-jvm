import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/sliding-window-maximum/
 */
class Problem239 {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val queue = PriorityQueue<Int> { o1, o2 -> -o1.compareTo(o2) }
        for (i in 0 until k) queue.add(nums[i])
        val result = mutableListOf<Int>()
        result.add(queue.peek()!!)
        for (i in k until nums.size) {
            queue.remove(nums[i - k])
            queue.add(nums[i])
            result.add(queue.peek()!!)
        }
        return result.toIntArray()
    }
}

fun main() {
    val problem = Problem239()
    val actual = problem.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
    check(actual.contentEquals(intArrayOf(3, 3, 5, 5, 6, 7)))
}
