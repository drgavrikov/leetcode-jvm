package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1254Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1254 = Problem1254()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val grid = arrayOf(
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
                    intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
                    intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
                )
                val actual = problem1254.closedIsland(grid)
                Assertions.assertThat(actual).isEqualTo(2)
            },
            DynamicTest.dynamicTest("test2") {
                val grid = arrayOf(
                    intArrayOf(0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 1, 0),
                    intArrayOf(0, 1, 1, 1, 0)
                )
                val actual = problem1254.closedIsland(grid)
                Assertions.assertThat(actual).isEqualTo(1)
            },
        )
    }
}
