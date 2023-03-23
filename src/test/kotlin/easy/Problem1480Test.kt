package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1480Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1480 = Problem1480()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1480.runningSum(intArrayOf(1, 2, 3, 4))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(1, 3, 6, 10))
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1480.runningSum(intArrayOf(1, 1, 1, 1, 1))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(1, 2, 3, 4, 5))
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem1480.runningSum(intArrayOf(1, 2, 3))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(1, 3, 6))
            },
        )
    }
}
