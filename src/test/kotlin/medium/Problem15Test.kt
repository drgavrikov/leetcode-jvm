package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem15Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem15()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
                Assertions.assertThat(actual).isEqualTo(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)))
            },
        )
    }
}
