package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem222Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem222 = Problem222()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val node1 = Problem222.TreeNode(1)
                val node2 = Problem222.TreeNode(2)
                val node3 = Problem222.TreeNode(3)
                val node4 = Problem222.TreeNode(4)
                val node5 = Problem222.TreeNode(3)
                val node6 = Problem222.TreeNode(4)

                node1.left = node2
                node1.right = node3

                node2.left = node4
                node2.right = node5

                node3.left = node6
                Assertions.assertThat(problem222.countNodes(root = node1)).isEqualTo(6)
            },
        )
    }
}
