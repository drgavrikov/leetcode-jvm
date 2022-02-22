package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem61Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem61 = Problem61()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem61.minPathSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
                Assertions.assertThat(actual).isEqualTo(12)
            },
        )
    }
}
