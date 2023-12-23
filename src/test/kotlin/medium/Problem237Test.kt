package medium

import AbstractTest
import ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem237Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem237()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val node4 = ListNode(9)
                val node3 = ListNode(1)
                val node2 = ListNode(5)
                val node1 = ListNode(4)
                node1.next = node2
                node2.next = node3
                node3.next = node4

                problem.deleteNode(node1)

                Assertions.assertThat(node1.next).isEqualTo(node3)
            },
        )
    }
}
