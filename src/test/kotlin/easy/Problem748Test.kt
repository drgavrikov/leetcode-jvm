package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem748Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem748 = Problem748()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem748.shortestCompletingWord("1s3 PSt", arrayOf("step", "steps", "stripe", "stepple"))
                Assertions.assertThat(actual).isEqualTo("steps")
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem748.shortestCompletingWord("1s3 456", arrayOf("looks", "pest", "stew", "show"))
                Assertions.assertThat(actual).isEqualTo("pest")
            }
        )
    }
}
