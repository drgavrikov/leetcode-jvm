package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem2273Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem2273()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.removeAnagrams(arrayOf("abba", "baba", "bbaa", "cd", "cd"))
                Assertions.assertThat(actual).isEqualTo(listOf("abba", "cd"))
            }
        )
    }
}
