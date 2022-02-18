package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1423Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1423 = Problem1423()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1423.maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3)
                Assertions.assertThat(actual).isEqualTo(12)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1423.maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7)
                Assertions.assertThat(actual).isEqualTo(55)
            },
        )
    }
}
