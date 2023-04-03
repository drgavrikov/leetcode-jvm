package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem121Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem121()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
                Assertions.assertThat(actual).isEqualTo(5)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.maxProfit(intArrayOf(7, 6, 4, 3, 1))
                Assertions.assertThat(actual).isEqualTo(0)
            },
        )
    }
}
