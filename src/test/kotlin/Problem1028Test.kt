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
class Problem1028Test {

    private val problem1028 = Problem1028()

    @ParameterizedTest
    @MethodSource("input")
    fun test(string: String) {
        val tree = problem1028.recoverFromPreorder(string)
        Assertions.assertThat(tree?.`val`).isEqualTo(1)
        Assertions.assertThat(tree?.left?.`val`).isEqualTo(401)
        Assertions.assertThat(tree?.left?.left?.`val`).isEqualTo(349)
    }

    private fun input(): List<Arguments> {
        return listOf(Arguments.of("1-401--349---90--88"))
    }
}
