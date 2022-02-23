package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem14Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem14 = Problem14()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem14.longestCommonPrefix(arrayOf("flower", "flow", "flight"))
                Assertions.assertThat(actual).isEqualTo("fl")
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem14.longestCommonPrefix(arrayOf("dog", "racecar", "car"))
                Assertions.assertThat(actual).isEqualTo("")
            },
        )
    }
}
