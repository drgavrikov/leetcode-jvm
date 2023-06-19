package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem2089Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem2089()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val nums = intArrayOf(1, 2, 5, 2, 3)
                val actual = problem.targetIndices(nums, 2)
                Assertions.assertThat(actual).isEqualTo(listOf(1, 2))
            }
        )
    }
}
