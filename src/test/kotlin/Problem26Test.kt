import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem26Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem26 = Problem26()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem26.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
                Assertions.assertThat(actual).isEqualTo(5)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem26.removeDuplicates(intArrayOf(1, 2))
                Assertions.assertThat(actual).isEqualTo(2)
            },
        )
    }
}
