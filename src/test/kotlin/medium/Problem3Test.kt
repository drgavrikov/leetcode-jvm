package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem3Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem3()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.lengthOfLongestSubstring("abcabcbb")
                Assertions.assertThat(actual).isEqualTo(3)
            },
            DynamicTest.dynamicTest("test1") {
                val actual = problem.lengthOfLongestSubstring("bbbbb")
                Assertions.assertThat(actual).isEqualTo(1)
            }
        )
    }
}
