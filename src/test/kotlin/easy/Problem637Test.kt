package easy

import AbstractTest
import TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem637Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem637 = Problem637()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val node1 = TreeNode(3)
                val node2 = TreeNode(9)
                val node3 = TreeNode(20)
                val node4 = TreeNode(15)
                val node5 = TreeNode(7)

                node1.left = node2
                node1.right = node3

                node3.left = node4
                node3.right = node5

                val actual = problem637.averageOfLevels(root = node1)
                Assertions.assertThat(actual).isEqualTo(doubleArrayOf(3.00000, 14.50000, 11.00000))
            }
        )
    }
}
