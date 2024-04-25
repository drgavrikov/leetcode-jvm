package medium

import kotlin.math.min
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/container-with-most-water/description/
 */
class Problem11 {

    fun maxArea(height: IntArray): Int {

        fun calcArea(left: Int, right: Int): Int{
            return min(height[left], height[right]) * (right - left)
        }

        var maxArea = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            maxArea = max(maxArea, calcArea(left, right))
            if (height[left] < height[right]) left++
            else right--
        }
        return maxArea
    }
}

fun main() {
    val problem = Problem11()

    runDynamicTest("test1") {
        val actual = problem.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        check(actual == 49) { "Expected 49, but got: $actual" }
    }

    runDynamicTest("test2") {
        val actual = problem.maxArea(intArrayOf(2, 1, 2))
        check(actual == 4) { "Expected 4, but got: $actual" }
    }
}
