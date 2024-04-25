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

fun main() {
    val problem = Problem19()

    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    val head = problem.removeNthFromEnd(head = node1, 2)

    check(head?.next?.next == node3) { "Expected ${node3}, but got: ${head?.next?.next}" }
    check(head?.next?.next?.next == node5) { "Expected ${node5}, but got: ${head?.next?.next?.next}" }
}
