/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/intersection-of-two-arrays/solutions/5265597/set-intersection/
 */
class Problem349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val unique1 = nums1.toSet()
        val unique2 = nums2.toSet()
        return unique1.intersect(unique2).toIntArray()
    }
}

fun main() {
    val problem = Problem349()
    check(problem.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentEquals(intArrayOf(2)))
}
