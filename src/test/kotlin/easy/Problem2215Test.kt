package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem2215Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem2215()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val num1 = intArrayOf(1, 2, 3)
                val num2 = intArrayOf(2, 4, 6)
                val actual = problem.findDifference(num1, num2)
                Assertions.assertThat(actual).isEqualTo(listOf(listOf(1, 3), listOf(4, 6)))
            }
        )
    }
}
