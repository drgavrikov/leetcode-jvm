package hard

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1028Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1028 = Problem1028()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val tree = problem1028.recoverFromPreorder("1-401--349---90--88")
                Assertions.assertThat(tree?.`val`).isEqualTo(1)
                Assertions.assertThat(tree?.left?.`val`).isEqualTo(401)
                Assertions.assertThat(tree?.left?.left?.`val`).isEqualTo(349)
            }
        )
    }
}
