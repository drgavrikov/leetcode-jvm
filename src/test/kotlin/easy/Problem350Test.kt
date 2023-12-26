package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem350Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem350()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(2, 2))
            },
        )
    }
}
