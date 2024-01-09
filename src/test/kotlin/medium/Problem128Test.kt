package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem128Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem128()

        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))
                Assertions.assertThat(actual).isEqualTo(9)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))
                Assertions.assertThat(actual).isEqualTo(4)
            },
        )
    }
}
