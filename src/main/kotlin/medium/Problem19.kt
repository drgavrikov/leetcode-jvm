package medium

import ListNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/remove-nth-node-from-end-of-list
 */
class Problem19 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var lf = head
        var rt = head
        repeat(n) {
            rt = rt?.next
        }
        if (rt == null) return head?.next
        while (rt?.next != null) {
            lf = lf?.next
            rt = rt?.next
        }
        lf?.next = lf?.next?.next
        return head
    }
}
