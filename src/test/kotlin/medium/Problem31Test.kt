package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem31Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem31()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val nums = intArrayOf(1, 2, 3)
                problem.nextPermutation(nums)
                Assertions.assertThat(nums).isEqualTo(intArrayOf(1, 3, 2))
            },
            DynamicTest.dynamicTest("test2") {
                val nums = intArrayOf(3, 2, 1)
                problem.nextPermutation(nums)
                Assertions.assertThat(nums).isEqualTo(intArrayOf(1, 2, 3))
            },
        )
    }
}
