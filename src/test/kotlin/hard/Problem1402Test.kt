package hard

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1402Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1402 = Problem1402()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1402.maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9))
                Assertions.assertThat(actual).isEqualTo(14)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1402.maxSatisfaction(intArrayOf(4, 3, 2))
                Assertions.assertThat(actual).isEqualTo(20)
            }
        )
    }
}
