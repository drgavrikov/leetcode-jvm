package easy

import AbstractTest
import TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem938Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem938()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val node3 = TreeNode(3)

                val node5 = TreeNode(5)

                val node18 = TreeNode(18)

                val node7 = TreeNode(7)
                node5.left = node3
                node5.right = node7

                val node15 = TreeNode(15)
                node15.right = node18

                val node10 = TreeNode(10)
                node10.left = node5
                node10.right = node15

                val actual = problem.rangeSumBST(node10, 7, 15)
                Assertions.assertThat(actual).isEqualTo(32)
            }
        )
    }
}
