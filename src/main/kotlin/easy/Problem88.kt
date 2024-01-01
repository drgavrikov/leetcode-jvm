package easy

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/merge-sorted-array/description/
 */
class Problem88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index1 = m - 1
        var index2 = n - 1
        var index = n + m - 1
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[index--] = nums1[index1--]
            } else {
                nums1[index--] = nums2[index2--]
            }
        }
        while (index2 >= 0) nums1[index--] = nums2[index2--]
    }
}
