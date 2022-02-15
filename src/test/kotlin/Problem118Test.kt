import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem118Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem118 = Problem118()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem118.generate(5)
                val triangle = listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1),
                    listOf(1, 4, 6, 4, 1),
                )
                Assertions.assertThat(actual).isEqualTo(triangle)
            },
        )
    }
}
