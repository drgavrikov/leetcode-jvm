package hard

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem10Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem10 = Problem10()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                Assertions.assertThat(problem10.isMatch("ab", ".*c")).isFalse
                Assertions.assertThat(problem10.isMatch("aa", "a.")).isTrue
                Assertions.assertThat(problem10.isMatch("aa", "a*")).isTrue
                Assertions.assertThat(problem10.isMatch("aa", "a")).isFalse
                Assertions.assertThat(problem10.isMatch("aab", "c*a*b")).isTrue
                Assertions.assertThat(problem10.isMatch("mississippi", "mis*is*p*.")).isFalse
            }
        )
    }
}
