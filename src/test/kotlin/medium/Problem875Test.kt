package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem875Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem875()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8)
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5)
                Assertions.assertThat(actual).isEqualTo(30  )
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6)
                Assertions.assertThat(actual).isEqualTo(23)
            },
        )
    }
}
