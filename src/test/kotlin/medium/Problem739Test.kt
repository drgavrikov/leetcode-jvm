package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem739Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem739()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0))
            },
        )
    }
}
