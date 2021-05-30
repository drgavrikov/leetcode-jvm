import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1255Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1255 = Problem1255()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1255.maxScoreWords(
                    arrayOf("dog", "cat", "dad", "good"),
                    charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
                    intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                )
                Assertions.assertThat(actual).isEqualTo(23)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1255.maxScoreWords(
                    arrayOf("leetcode"),
                    charArrayOf('l', 'e', 't', 'c', 'o', 'd'),
                    intArrayOf(0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
                )
                Assertions.assertThat(actual).isEqualTo(0)
            }
        )
    }
}
