package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem809Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem809 = Problem809()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem809.expressiveWords("heeellooo", arrayOf("hello", "hi", "helo"))
                Assertions.assertThat(actual).isEqualTo(1)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem809.expressiveWords("aaa", arrayOf("aaaa"))
                Assertions.assertThat(actual).isEqualTo(0)
            },
        )
    }
}
