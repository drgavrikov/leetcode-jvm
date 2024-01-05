package medium

import AbstractTest
import TreeNode
import org.junit.jupiter.api.DynamicTest

class Problem114Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem114()

        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)

        node2.left = node3
        node2.right = node4
        node5.right = node6
        node1.left = node2
        node1.right = node5

        return listOf(
            DynamicTest.dynamicTest("test1") {
                problem.flatten(node1)
            },
        )
    }
}
