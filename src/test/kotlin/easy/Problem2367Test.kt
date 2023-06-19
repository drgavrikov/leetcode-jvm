package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem2367Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem2367()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val nums = intArrayOf(0, 1, 4, 6, 7, 10)
                val diff = 3
                val actual = problem.arithmeticTriplets(nums, diff)
                Assertions.assertThat(actual).isEqualTo(2)
            }
        )
    }
}
