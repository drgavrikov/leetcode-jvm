package easy

import AbstractTest
import TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem100Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem100 = Problem100()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val p = TreeNode(1)
                p.left = TreeNode(2)
                p.right = TreeNode(3)

                val q = TreeNode(1)
                q.left = TreeNode(2)
                q.right = TreeNode(3)

                val actual = problem100.isSameTree(p, q)
                Assertions.assertThat(actual).isTrue()
            },
            DynamicTest.dynamicTest("test2") {
                val p = TreeNode(1)
                p.left = TreeNode(2)

                val q = TreeNode(1)
                q.right = TreeNode(2)

                val actual = problem100.isSameTree(p, q)
                Assertions.assertThat(actual).isFalse()
            },
        )
    }
}
