package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1136Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem1136()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.minimumSemesters(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))
                Assertions.assertThat(actual).isEqualTo(2)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.minimumSemesters(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1)))
                Assertions.assertThat(actual).isEqualTo(-1)
            }
        )
    }
}
