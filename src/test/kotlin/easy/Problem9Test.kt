package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem9Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem9 = Problem9()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem9.isPalindrome(121)
                Assertions.assertThat(actual).isTrue()
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem9.isPalindrome(-121)
                Assertions.assertThat(actual).isFalse()
            },
        )
    }
}
