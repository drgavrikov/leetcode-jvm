package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1672Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1672 = Problem1672()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1672.maximumWealth(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
                )
                Assertions.assertThat(actual).isEqualTo(6)
            }
        )
    }
}
