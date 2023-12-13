package medium

import AbstractTest
import TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem652Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem652 = Problem652()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val node1 = TreeNode(1)
                val node2 = TreeNode(2)
                val node3 = TreeNode(2)
                val node4 = TreeNode(3)
                val node5 = TreeNode(3)

                node1.left = node2
                node1.right = node3

                node2.left = node4
                node3.left = node5

                val actual = problem652.findDuplicateSubtrees(node1)
                Assertions.assertThat(actual.toSet()).isEqualTo(setOf(node3, node5))
            }
        )
    }
}
