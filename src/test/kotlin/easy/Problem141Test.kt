package easy

import AbstractTest
import ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem141Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem141()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val node3 = ListNode(3)
                val node2 = ListNode(2)
                val node0 = ListNode(0)
                val node4 = ListNode(4)

                node3.next = node2
                node2.next = node0
                node0.next = node4
                node4.next = node2

                Assertions.assertThat(problem.hasCycle(node3)).isTrue()
            },
            DynamicTest.dynamicTest("test2") {
                val node1 = ListNode(2)
                val node2 = ListNode(2)

                node1.next = node2
                node2.next = node1

                Assertions.assertThat(problem.hasCycle(node1)).isTrue()
            },
            DynamicTest.dynamicTest("test3") {
                val node1 = ListNode(2)
                val node2 = ListNode(2)

                node1.next = node2

                Assertions.assertThat(problem.hasCycle(node1)).isFalse()
            },
        )
    }
}
