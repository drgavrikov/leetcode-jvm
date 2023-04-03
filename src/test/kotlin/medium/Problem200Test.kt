package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem200Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem200()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.numIslands(arrayOf(
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '1', '1')
                ))
                Assertions.assertThat(actual).isEqualTo(3)
            },
        )
    }
}
