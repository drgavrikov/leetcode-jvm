import java.util.PriorityQueue

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/merge-k-sorted-lists/solutions/5349213/populating-the-priority-queue/
 */
class Problem23 {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val head = ListNode(-1)
        var tail: ListNode? = head

        val queue = PriorityQueue<ListNode>(compareBy { it.`val` })
        lists.filterNotNull().forEach { node -> queue.add(node) }

        while (queue.isNotEmpty()) {
            val minNode = queue.poll()
            if (minNode.next != null) {
                queue.add(minNode.next)
            }

            tail?.next = minNode
            tail = tail?.next
        }
        return head.next
    }
}

fun main() {
    val problem = Problem23()

    val list1 = ListNode(1).apply { next = ListNode(4).apply { next = ListNode(5) } }
    val list2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    val list3 = ListNode(2).apply { next = ListNode(6) }

    var actual = problem.mergeKLists(arrayOf(list1, list2, list3))
    val expected = listOf(1, 1, 2, 3, 4, 4, 5, 6)
    for (value in expected) {
        check(actual?.`val` == value)
        actual = actual?.next
    }
}
