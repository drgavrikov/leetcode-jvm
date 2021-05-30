import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1284Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1284 = Problem1284()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1284.minFlips(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)))
                Assertions.assertThat(actual).isEqualTo(3)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1284.minFlips(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))
                Assertions.assertThat(actual).isEqualTo(0)
            }
        )
    }
}
