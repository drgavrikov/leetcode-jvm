package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem227Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem227()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                Assertions.assertThat(problem.calculate("3+2*2")).isEqualTo(7)
            },
            DynamicTest.dynamicTest("test2") {
                Assertions.assertThat(problem.calculate(" 3+5 / 2 ")).isEqualTo(5)
            },
        )
    }
}
