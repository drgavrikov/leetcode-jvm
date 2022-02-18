package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1048Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1048 = Problem1048()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1048.longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca"))
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1048.longestStrChain(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc"))
                Assertions.assertThat(actual).isEqualTo(5)
            },
        )
    }
}
