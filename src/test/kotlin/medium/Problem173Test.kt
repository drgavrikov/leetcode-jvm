package medium

import AbstractTest
import TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem173Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem173()

        val node9 = TreeNode(9)
        val node20 = TreeNode(20)
        val node15 = TreeNode(15)
        val node7 = TreeNode(7)
        val node3 = TreeNode(3)

        node15.left = node9
        node15.right = node20
        node7.left = node3
        node7.right = node15

        return listOf(
            DynamicTest.dynamicTest("test1") {
                val iterator = problem.BSTIterator(node7)
                Assertions.assertThat(iterator.next()).isEqualTo(3)
                Assertions.assertThat(iterator.next()).isEqualTo(7)
                Assertions.assertThat(iterator.hasNext()).isTrue()
                Assertions.assertThat(iterator.next()).isEqualTo(9)
                Assertions.assertThat(iterator.hasNext()).isTrue()
                Assertions.assertThat(iterator.next()).isEqualTo(15)
                Assertions.assertThat(iterator.hasNext()).isTrue()
                Assertions.assertThat(iterator.next()).isEqualTo(20)
                Assertions.assertThat(iterator.hasNext()).isFalse()
            },
        )
    }
}
