package medium

import AbstractTest
import hard.Problem987
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem987Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem987 = Problem987()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val root = Problem987.TreeNode(3)

                root.left = Problem987.TreeNode(9)
                root.right = Problem987.TreeNode(20)

                root.right!!.left = Problem987.TreeNode(15)
                root.right!!.right = Problem987.TreeNode(7)

                val actual = problem987.verticalTraversal(root)
                Assertions.assertThat(actual).isEqualTo(listOf(listOf(9), listOf(3, 15), listOf(20), listOf(7)))
            },
            DynamicTest.dynamicTest("test2") {
                val root = Problem987.TreeNode(1)

                root.left = Problem987.TreeNode(2)
                root.right = Problem987.TreeNode(3)

                root.left!!.left = Problem987.TreeNode(4)
                root.left!!.right = Problem987.TreeNode(5)
                root.right!!.left = Problem987.TreeNode(6)
                root.right!!.right = Problem987.TreeNode(7)

                val actual = problem987.verticalTraversal(root)
                Assertions.assertThat(actual).isEqualTo(
                    listOf(listOf(4), listOf(2), listOf(1, 5, 6), listOf(3), listOf(7))
                )
            },
        )
    }
}
