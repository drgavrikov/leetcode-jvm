import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith


@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform::class)
class Problem1284Test {

    private val problem1284 = Problem1284()

    @ParameterizedTest
    @MethodSource("input")
    internal fun test(mat: Array<IntArray>, excepted: Int) {
        val actual = problem1284.minFlips(mat)
        Assertions.assertThat(actual).isEqualTo(excepted)
    }

    private fun input(): List<Arguments> {
        return listOf(
            Arguments.of(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)), 3),
            Arguments.of(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)), 0)
        )
    }
}
