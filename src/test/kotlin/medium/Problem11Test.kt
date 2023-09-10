package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem11Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem11()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
                Assertions.assertThat(actual).isEqualTo(49)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.maxArea(intArrayOf(2, 1, 2))
                Assertions.assertThat(actual).isEqualTo(4)
            },
        )
    }
}
