import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1463Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1463 = Problem1463()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1463.cherryPickup(
                    arrayOf(
                        intArrayOf(1, 1),
                        intArrayOf(1, 1)
                    )
                )
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1463.cherryPickup(
                    arrayOf(
                        intArrayOf(1, 0, 0, 3),
                        intArrayOf(0, 0, 0, 3),
                        intArrayOf(0, 0, 3, 3),
                        intArrayOf(9, 0, 3, 3),
                    )
                )
                Assertions.assertThat(actual).isEqualTo(22)
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem1463.cherryPickup(
                    arrayOf(
                        intArrayOf(1, 0, 0, 0, 0, 0, 1),
                        intArrayOf(2, 0, 0, 0, 0, 3, 0),
                        intArrayOf(2, 0, 9, 0, 0, 0, 0),
                        intArrayOf(0, 3, 0, 5, 4, 0, 0),
                        intArrayOf(1, 0, 2, 3, 0, 0, 6)
                    )
                )
                Assertions.assertThat(actual).isEqualTo(28)
            }
        )
    }
}
