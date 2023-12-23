package medium

import ListNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
class Problem237 {

    fun deleteNode(node: ListNode?) {
        if (node?.next == null) return
        val nextNode = node.next
        node?.`val` = nextNode?.`val`!!
        node?.next = nextNode?.next
    }
}
