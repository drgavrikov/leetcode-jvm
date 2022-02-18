package easy

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest


class Problem690Test : AbstractTest() {

    override fun dynamicTests(): Collection<DynamicTest> {
        val problem690 = Problem690()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val employee1 = Problem690.Employee(1, 5, listOf(2, 3))
                val employee2 = Problem690.Employee(2, 3, listOf())
                val employee3 = Problem690.Employee(3, 3, listOf())
                Assertions.assertThat(problem690.getImportance(listOf(employee1, employee2, employee3), 1))
                    .isEqualTo(11)
            }
        )
    }
}
