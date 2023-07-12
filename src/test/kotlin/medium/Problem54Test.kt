package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem54Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem54()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.spiralOrder(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
                )
                Assertions.assertThat(actual).isEqualTo(listOf(1, 2, 3, 6, 9, 8, 7, 4, 5))
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.spiralOrder(
                    arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
                )
                Assertions.assertThat(actual).isEqualTo(listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
            },
        )
    }
}
