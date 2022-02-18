package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem951Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem951 = Problem951()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val root1 = Problem951.TreeNode(1)
                root1.left = Problem951.TreeNode(2)
                root1.right = Problem951.TreeNode(3)
                root1.left!!.left = Problem951.TreeNode(4)
                root1.left!!.right = Problem951.TreeNode(5)
                root1.right!!.left = Problem951.TreeNode(6)

                val root2 = Problem951.TreeNode(1)
                root2.left = Problem951.TreeNode(3)
                root2.right = Problem951.TreeNode(2)
                root2.left!!.right = Problem951.TreeNode(6)
                root2.right!!.left = Problem951.TreeNode(4)
                root2.right!!.right = Problem951.TreeNode(5)
                
                val actual = problem951.flipEquiv(root1, root2)
                Assertions.assertThat(actual).isTrue()
            },
            DynamicTest.dynamicTest("test1") {
                val root1 = Problem951.TreeNode(1)
                val root2 = null

                val actual = problem951.flipEquiv(root1, root2)
                Assertions.assertThat(actual).isFalse()
            },
        )
    }
}
