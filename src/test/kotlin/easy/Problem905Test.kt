package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem905Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem905 = Problem905()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem905.sortArrayByParity(intArrayOf(3, 1, 2, 4))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(2, 4, 3, 1))
            },
        )
    }
}
