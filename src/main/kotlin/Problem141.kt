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

fun main() {
    val problem = Problem141()

    val node3 = ListNode(3)
    val node2 = ListNode(2)
    val node0 = ListNode(0)
    val node4 = ListNode(4)

    node3.next = node2
    node2.next = node0
    node0.next = node4
    node4.next = node2

    check(problem.hasCycle(node3)) { "Test failed: Expected true, actual: false" }

    val node1 = ListNode(2)
    val node22 = ListNode(2)

    node1.next = node22
    node22.next = node1

    check(problem.hasCycle(node1)) { "Test failed: Expected true, actual: false" }

    val node11 = ListNode(2)
    val node21 = ListNode(2)

    node11.next = node21

    check(!problem.hasCycle(node11)) { "Test failed: Expected false, actual: true" }
}
