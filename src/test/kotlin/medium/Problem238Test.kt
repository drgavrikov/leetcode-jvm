package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem238Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem238()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.productExceptSelf(intArrayOf(1, 2, 3, 4))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(24, 12, 8, 6))
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(0, 0, 9, 0, 0))
            },
        )
    }
}
