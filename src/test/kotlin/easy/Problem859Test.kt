package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem859Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem859 = Problem859()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem859.buddyStrings("aaa", "aaa")
                Assertions.assertThat(actual).isTrue()
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem859.buddyStrings("abc", "abc")
                Assertions.assertThat(actual).isFalse()
            }
        )
    }
}
