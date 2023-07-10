package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem53Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem53()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
                Assertions.assertThat(actual).isEqualTo(6)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.maxSubArray(intArrayOf(5, 4, -1, 7, 8))
                Assertions.assertThat(actual).isEqualTo(23)
            },
        )
    }
}
