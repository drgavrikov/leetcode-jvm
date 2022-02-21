package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem721Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem721 = Problem721()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val accounts = listOf(
                    listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                    listOf("John", "johnsmith@mail.com", "john00@mail.com"),
                    listOf("Mary", "mary@mail.com"),
                    listOf("John", "johnnybravo@mail.com")
                )
                val result = listOf(
                    listOf("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                    listOf("Mary", "mary@mail.com"),
                    listOf("John", "johnnybravo@mail.com")
                )
                Assertions.assertThat(problem721.accountsMerge(accounts)).isEqualTo(result)
            },
        )
    }
}
