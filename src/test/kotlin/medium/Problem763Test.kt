package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem763Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem763 = Problem763()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem763.partitionLabels("ababcbacadefegdehijhklij")
                Assertions.assertThat(actual).isEqualTo(listOf(9, 7, 8))
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem763.partitionLabels("eccbbbbdec")
                Assertions.assertThat(actual).isEqualTo(listOf(10))
            },
        )
    }
}
