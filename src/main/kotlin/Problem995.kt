/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/solutions/5364120/single-pass-solution-with-deque/
 */
class Problem995 {

    fun minKBitFlips(nums: IntArray, k: Int): Int {
        val deque = ArrayDeque<Int>()
        var flips = 0

        for (index in nums.indices) {
            if (deque.isNotEmpty() && deque.first() < index) deque.removeFirst()
            if ((nums[index] + deque.size) % 2 == 0) {
                if (index + k > nums.size) return -1

                deque.addLast(index + k - 1)
                flips++
            }
        }
        return flips
    }
}

fun main() {
    val problem = Problem995()
    check(problem.minKBitFlips(intArrayOf(0, 1, 0), 1) == 2)
    check(problem.minKBitFlips(intArrayOf(1, 1, 0), 2) == -1)
    check(problem.minKBitFlips(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3) == 3)
}
