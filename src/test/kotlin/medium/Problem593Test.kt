package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem593Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem593 = Problem593()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem593.validSquare(
                    intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(0, 1), intArrayOf(1, 0))
                Assertions.assertThat(actual).isTrue()
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem593.validSquare(
                    intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 12))
                Assertions.assertThat(actual).isFalse()
            },
        )
    }
}
