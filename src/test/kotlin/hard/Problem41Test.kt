package hard

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem41Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem41 = Problem41()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem41.firstMissingPositive(
                    intArrayOf(1, 2, 0),
                )
                Assertions.assertThat(actual).isEqualTo(3)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem41.firstMissingPositive(
                    intArrayOf(3, 4, -1, 1),
                )
                Assertions.assertThat(actual).isEqualTo(2)
            }
        )
    }
}
