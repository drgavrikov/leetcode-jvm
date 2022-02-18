package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem1313Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1313 = Problem1313()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1313.decompressRLElist(intArrayOf(1, 2, 3, 4))
                Assertions.assertThat(actual).isEqualTo(intArrayOf(2, 4, 4, 4))
            },
        )
    }
}
