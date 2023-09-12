package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem22Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem22()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.generateParenthesis(3)
                Assertions.assertThat(actual).isEqualTo(listOf("((()))", "(()())", "(())()", "()(())", "()()()"))
            },
        )
    }
}
