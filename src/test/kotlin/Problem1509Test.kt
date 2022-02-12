import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1509Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1509 = Problem1509()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1509.minDifference(intArrayOf(5, 4, 2, 3))
                Assertions.assertThat(actual).isEqualTo(0)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1509.minDifference(intArrayOf(1, 5, 0, 10, 14))
                Assertions.assertThat(actual).isEqualTo(1)
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem1509.minDifference(intArrayOf(82, 81, 95, 75, 20))
                Assertions.assertThat(actual).isEqualTo(1)
            }
        )
    }
}
