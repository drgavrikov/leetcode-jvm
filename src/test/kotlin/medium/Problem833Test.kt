package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem833Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem833 = Problem833()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem833.findReplaceString(
                    "abcd",
                    intArrayOf(0, 2),
                    arrayOf("a", "cd"),
                    arrayOf("eee", "ffff"),
                )
                Assertions.assertThat(actual).isEqualTo("eeebffff")
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem833.findReplaceString(
                    "abcd",
                    intArrayOf(0, 2),
                    arrayOf("ab", "ec"),
                    arrayOf("eee", "ffff"),
                )
                Assertions.assertThat(actual).isEqualTo("eeecd")
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem833.findReplaceString(
                    "abcde",
                    intArrayOf(2, 2),
                    arrayOf("cde", "cdef"),
                    arrayOf("fe", "f"),
                )
                Assertions.assertThat(actual).isEqualTo("abfe")
            },
        )
    }
}
