package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1631Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1631 = Problem1631()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1631.minimumEffortPath(
                    arrayOf(
                        intArrayOf(1, 2, 2),
                        intArrayOf(3, 8, 2),
                        intArrayOf(5, 3, 5),
                    )
                )
                Assertions.assertThat(actual).isEqualTo(2)
            },
        )
    }
}
