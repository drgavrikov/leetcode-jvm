package medium

import AbstractTest
import TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1110Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem1110()

        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)
        val node7 = TreeNode(7)

        node1.left = node2
        node1.right = node3
        node2.left = node4
        node2.right = node5
        node3.left = node6
        node3.right = node7

        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.delNodes(node1, intArrayOf(3, 4))
                Assertions.assertThat(actual).isEqualTo(listOf(node1, node6, node7))
            },
        )
    }
}
