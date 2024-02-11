package medium

import AbstractTest
import ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem19Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem19()
        return listOf(
            DynamicTest.dynamicTest("test1") {
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

                Assertions.assertThat(head?.next?.next).isEqualTo(node3)
                Assertions.assertThat(head?.next?.next?.next).isEqualTo(node5)
            },
        )
    }
}
