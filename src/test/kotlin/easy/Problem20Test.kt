package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem20Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem20()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.isValid("(){}[]")
                Assertions.assertThat(actual).isEqualTo(true)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.isValid("([)]")
                Assertions.assertThat(actual).isEqualTo(false)
            },
        )
    }
}
