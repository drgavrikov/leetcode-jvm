package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1011Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1011 = Problem1011()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1011.shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5)
                Assertions.assertThat(actual).isEqualTo(15)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1011.shipWithinDays(intArrayOf(3, 2, 2, 4, 1, 4), 3)
                Assertions.assertThat(actual).isEqualTo(6)
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem1011.shipWithinDays(intArrayOf(1, 2, 3, 1, 1), 4)
                Assertions.assertThat(actual).isEqualTo(3)
            },
        )
    }
}
