package medium

import AbstractTest
import ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem443Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem443()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val chars = charArrayOf('a', 'a', 'a', 'b', 'b', 'a', 'a')
                val actual = problem.compress(chars)
                Assertions.assertThat(actual).isEqualTo(6)
            },
        )
    }
}
