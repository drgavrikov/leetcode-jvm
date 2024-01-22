package medium

import java.util.*

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/daily-temperatures/
 */
class Problem739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val indices = Stack<Int>()
        val result = IntArray(temperatures.size) { 0 }
        temperatures.indices.forEach { index ->
            while (indices.isNotEmpty() && temperatures[index] > temperatures[indices.last()]) {
                val last = indices.pop()!!
                result[last] = index - last
            }
            indices.add(index)
        }
        return result
    }
}
