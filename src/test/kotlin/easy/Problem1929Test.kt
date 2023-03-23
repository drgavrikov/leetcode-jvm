package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1929Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1929 = Problem1929()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1929.getConcatenation(intArrayOf(1, 2, 1))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(1, 2, 1, 1, 2, 1))
            }
        )
    }
}
