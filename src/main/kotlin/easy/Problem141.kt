package easy

import ListNode


/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/linked-list-cycle/
 */
class Problem141 {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) return true
        }
        return false
    }
}
