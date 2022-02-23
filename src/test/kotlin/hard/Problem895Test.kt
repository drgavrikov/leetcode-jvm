package hard

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem895Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val freqStack = Problem895.FreqStack()
                freqStack.push(5)
                freqStack.push(7)
                freqStack.push(5)
                freqStack.push(7)
                freqStack.push(4)
                freqStack.push(5)
                Assertions.assertThat(freqStack.pop()).isEqualTo(5)
                Assertions.assertThat(freqStack.pop()).isEqualTo(7)
                Assertions.assertThat(freqStack.pop()).isEqualTo(5)
                Assertions.assertThat(freqStack.pop()).isEqualTo(4)
            }
        )
    }
}
