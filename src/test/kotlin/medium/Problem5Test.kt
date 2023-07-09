package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem5Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem5()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.longestPalindrome("babad")
                Assertions.assertThat(actual).isEqualTo("bab")
            }
        )
    }
}
