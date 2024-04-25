package medium

import ListNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
class Problem237 {

    fun deleteNode(node: ListNode?) {
        if (node?.next == null) return
        val nextNode: ListNode? = node.next
        node.`val` = nextNode?.`val`!!
        node.next = nextNode?.next
    }
}

fun main() {
    val problem = Problem237()

    val node4 = ListNode(9)
    val node3 = ListNode(1)
    val node2 = ListNode(5)
    val node1 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4

    problem.deleteNode(node1)

    check(node1.next == node3) { "Test 1 failed: Expected node1's next to be node3" }
}
