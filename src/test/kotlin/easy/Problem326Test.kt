package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem326Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem326 = Problem326()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem326.isPowerOfThree(3)
                Assertions.assertThat(actual).isTrue()
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem326.isPowerOfThree(-27)
                Assertions.assertThat(actual).isFalse()
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem326.isPowerOfThree(15)
                Assertions.assertThat(actual).isFalse()
            },
            DynamicTest.dynamicTest("test4") {
                val actual = problem326.isPowerOfThree(0)
                Assertions.assertThat(actual).isFalse()
            },
        )
    }
}
