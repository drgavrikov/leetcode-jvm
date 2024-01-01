package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem88Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem88()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val num1 = intArrayOf(1, 2, 3, 0, 0, 0)
                val n = 3
                val num2 = intArrayOf(2, 5, 6)
                val m = 3
                problem.merge(num1, n, num2, m)
                Assertions.assertThat(num1).isEqualTo(intArrayOf(1, 2, 2, 3, 5, 6))
            },
        )
    }
}
