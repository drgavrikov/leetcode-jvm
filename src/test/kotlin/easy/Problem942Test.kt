package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem942Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem942()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.diStringMatch("IDID")
                Assertions.assertThat(actual).isEqualTo(intArrayOf(0, 4, 1, 3, 2))
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.diStringMatch("III")
                Assertions.assertThat(actual).isEqualTo(intArrayOf(0, 1, 2, 3))
            }
        )
    }
}
