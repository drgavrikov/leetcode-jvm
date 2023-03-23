package medium

import AbstractTest
import TreeNode
import hard.Problem987
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem987Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem987 = Problem987()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val root = TreeNode(3)

                root.left = TreeNode(9)
                root.right = TreeNode(20)

                root.right!!.left = TreeNode(15)
                root.right!!.right = TreeNode(7)

                val actual = problem987.verticalTraversal(root)
                Assertions.assertThat(actual).isEqualTo(listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7)))
            },
            DynamicTest.dynamicTest("test2") {
                val root = TreeNode(1)

                root.left = TreeNode(2)
                root.right = TreeNode(3)

                root.left!!.left = TreeNode(4)
                root.left!!.right = TreeNode(5)
                root.right!!.left = TreeNode(6)
                root.right!!.right = TreeNode(7)

                val actual = problem987.verticalTraversal(root)
                Assertions.assertThat(actual).isEqualTo(
                    listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7))
                )
            },
        )
    }
}
