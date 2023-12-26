package easy

import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
class Problem350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val frequency1 = nums1.toList()
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        val frequency2 = nums2.toList()
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        val intersection = mutableMapOf<Int, Int>()
        frequency1.forEach { (key, value) ->
            intersection[key] = min(value, frequency2.getOrDefault(key, 0))
        }
        frequency2.forEach { (key, value) ->
            intersection[key] = min(value, frequency1.getOrDefault(key, 0))
        }
        return intersection
            .flatMap { (key, value) -> (0 until value).map { key } }
            .toIntArray()
    }
}
