package medium

import AbstractTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DynamicTest

class Problem49Test : AbstractTest() {
    override fun dynamicTests(): Collection<DynamicTest> {
        val problem = Problem49()
        return listOf(
            DynamicTest.dynamicTest("test1") {
                val actual = problem.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
                val excepted = listOf(
                    listOf("bat"),
                    listOf("nat", "tan"),
                    listOf("ate", "eat", "tea")
                )
                Assertions.assertThat(actual.size).isEqualTo(excepted.size)
                val sortedActual = actual.map { list -> list.sorted() }.sortedBy { it.first() }
                val sortedExcepted = excepted.map { list -> list.sorted() }.sortedBy { it.first() }
                sortedActual.zip(sortedExcepted).forEach { (actualList, exceptedList) ->
                    Assertions.assertThat(actualList).isEqualTo(exceptedList)
                }
            },
        )
    }
}
