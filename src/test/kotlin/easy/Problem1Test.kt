package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem1()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.twoSum(intArrayOf(2, 7, 11, 15), 9)
                Assertions.assertThat(actual).isEqualTo(intArrayOf(0, 1))
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem.twoSum(intArrayOf(3, 2, 4), 6)
                Assertions.assertThat(actual).isEqualTo(intArrayOf(1, 2))
            },
        )
    }
}
