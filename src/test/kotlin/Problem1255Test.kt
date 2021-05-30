import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith


@TestInstance(PER_CLASS)
    @RunWith(JUnitPlatform::class)
class Problem1255Test {

    private val problem1255 = Problem1255()

    @ParameterizedTest
    @MethodSource("input")
    fun test(words: Array<String>, letters: CharArray, score: IntArray, excepted: Int) {
        val actual = problem1255.maxScoreWords(words, letters, score)
        Assertions.assertThat(actual).isEqualTo(excepted)
    }

    private fun input(): List<Arguments> {
        return listOf(
            Arguments.of(
                arrayOf("dog", "cat", "dad", "good"),
                charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
                intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                23
            ),
            Arguments.of(
                arrayOf("leetcode"),
                charArrayOf('l', 'e', 't', 'c', 'o', 'd'),
                intArrayOf(0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                0
            ),
        )
    }
}
