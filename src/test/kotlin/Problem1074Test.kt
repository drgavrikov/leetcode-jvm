import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1074Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1074 = Problem1074()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1074.numSubmatrixSumTarget(
                    arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0)),
                    0
                )
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1074.numSubmatrixSumTarget(
                    arrayOf(
                        intArrayOf(0, 1, 1, 1, 0, 1),
                        intArrayOf(0, 0, 0, 0, 0, 1),
                        intArrayOf(0, 0, 1, 0, 0, 1),
                        intArrayOf(1, 1, 0, 1, 1, 0),
                        intArrayOf(1, 0, 0, 1, 0, 0)
                    ),
                    0
                )
                Assertions.assertThat(actual).isEqualTo(43)
            },
        )
    }
}
