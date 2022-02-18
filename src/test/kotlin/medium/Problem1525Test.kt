package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1525Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1525 = Problem1525()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1525.numSplits("aacaba")
                Assertions.assertThat(actual).isEqualTo(2)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1525.numSplits("abcd")
                Assertions.assertThat(actual).isEqualTo(1)
            },
        )
    }
}
