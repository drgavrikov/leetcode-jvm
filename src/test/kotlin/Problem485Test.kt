import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem485Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem485 = Problem485()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem485.findMaxConsecutiveOnes(intArrayOf(1,1,0,1,1,1))
                Assertions.assertThat(actual).isEqualTo(3)
            },
        )
    }
}
