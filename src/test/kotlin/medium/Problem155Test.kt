package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem155Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val minStack = Problem155().MinStack()

        return listOf(
            DynamicTest.dynamicTest("test1") {
                minStack.push(-2)
                minStack.push(0)
                minStack.push(-3)
                Assertions.assertThat(-3).isEqualTo(minStack.getMin())
                minStack.pop()
                Assertions.assertThat(0).isEqualTo(minStack.top())
                Assertions.assertThat(-2).isEqualTo(minStack.getMin())
            },
        )
    }
}
