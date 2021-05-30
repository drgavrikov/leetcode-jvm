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
class Problem1402Test {

    private val problem1402 = Problem1402()

    @ParameterizedTest
    @MethodSource("input")
    fun test(satisfaction: IntArray, excepted: Int) {
        val actual = problem1402.maxSatisfaction(satisfaction)
        Assertions.assertThat(actual).isEqualTo(excepted)
    }

    private fun input(): List<Arguments> {
        return listOf(
            Arguments.of(intArrayOf(-1, -8, 0, 5, -9), 14),
            Arguments.of(intArrayOf(4, 3, 2), 20),
        )
    }
}
