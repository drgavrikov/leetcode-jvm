package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem412Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem412 = Problem412()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem412.fizzBuzz(15)
                val result = listOf(
                    "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
                )
                Assertions.assertThat(actual).isEqualTo(result)
            },
        )
    }
}
