package medium

import ListNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/add-two-numbers/description/
 */
class Problem2 {

    private fun addNode(current: ListNode, value: Int): ListNode {
        val node = ListNode(value % 10)
        current.next = node
        return node
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null && l2 == null) return null

        val head = ListNode(0)
        var current = head

        var head1 = l1
        var head2 = l2
        var addDigit = 0

        while (head1 != null || head2 != null) {
            val sum = (head1?.`val` ?: 0) + (head2?.`val` ?: 0) + addDigit

            current = addNode(current, sum)
            addDigit = sum / 10

            head1 = head1?.next
            head2 = head2?.next
        }
        if (addDigit > 0) addNode(current, addDigit)
        return head.next
    }
}

fun main() {
    val problem2 = Problem2()
    test1(problem2)
    test2(problem2)
}

fun test1(problem2: Problem2) {
    val node2 = ListNode(2)
    val node4 = ListNode(4)
    val node3 = ListNode(3)
    val node9 = ListNode(9)
    node2.next = node4
    node4.next = node3
    node3.next = node9

    val node5 = ListNode(5)
    val node6 = ListNode(6)
    val node1 = ListNode(1)
    node5.next = node6
    node6.next = node1

    val actual = problem2.addTwoNumbers(node2, node5)
    checkNotNull(actual)
    check(actual.`val` == 7)
    check(actual.next!!.`val` == 0)
    check(actual.next!!.next!!.`val` == 5)
    check(actual.next!!.next!!.next!!.`val` == 9)
}

fun test2(problem2: Problem2) {
    val node1 = ListNode(9)
    val node2 = ListNode(9)
    node1.next = node2

    val node3 = ListNode(1)
    val actual = problem2.addTwoNumbers(node1, node3)
    checkNotNull(actual)
    check(actual.`val` == 0)
    check(actual.next!!.`val` == 0)
    check(actual.next!!.next!!.`val` == 1)
}
