package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem504Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem504()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.convertToBase7(100)
                Assertions.assertThat(actual).isEqualTo("202")
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.convertToBase7(-7)
                Assertions.assertThat(actual).isEqualTo("-10")
            },
            DynamicTest.dynamicTest("test1") {
                val actual = problem.convertToBase7(6)
                Assertions.assertThat(actual).isEqualTo("6")
            },
        )
    }
}
