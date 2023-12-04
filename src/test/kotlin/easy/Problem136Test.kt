package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem136Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem136 = Problem136()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem136.singleNumber(intArrayOf(2, 2, 1))
                Assertions.assertThat(actual).isEqualTo(1)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem136.singleNumber(intArrayOf(4, 1, 2, 1, 2))
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem136.singleNumber(intArrayOf(1))
                Assertions.assertThat(actual).isEqualTo(1)
            },
        )
    }
}
