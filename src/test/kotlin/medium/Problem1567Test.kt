package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1567Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1567 = Problem1567()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1567.getMaxLen(intArrayOf(1, -2, -3, 4))
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1567.getMaxLen(intArrayOf(1, 2, -3, 4))
                Assertions.assertThat(actual).isEqualTo(2)
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem1567.getMaxLen(intArrayOf(-1, 2, 0, 4, 0, -1, -2, -1))
                Assertions.assertThat(actual).isEqualTo(2)
            },
        )
    }
}
