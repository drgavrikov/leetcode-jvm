import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem1423Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem1423 = Problem1423()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem1423.longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca"))
                Assertions.assertThat(actual).isEqualTo(4)
            },
            DynamicTest.dynamicTest("test2") {
                val actual = problem1423.longestStrChain(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc"))
                Assertions.assertThat(actual).isEqualTo(5)
            },
            DynamicTest.dynamicTest("test3") {
                val actual = problem1423.longestStrChain(arrayOf("abcd", "dbqca"))
                Assertions.assertThat(actual).isEqualTo(1)
            },
        )
    }
}
