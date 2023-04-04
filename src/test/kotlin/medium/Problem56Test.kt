package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem56Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem56()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.merge(
                    arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
                )
                Assertions.assertThat(actual).isEqualTo(
                    arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
                )
            },
        )
    }
}
