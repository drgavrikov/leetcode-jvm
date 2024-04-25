package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/group-anagrams/
 */
class Problem49 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs
            .groupBy { str -> str.groupingBy { it }.eachCount() }
            .values
            .toList()
    }
}

fun main() {
    val problem = Problem49()

    runDynamicTest("test1") {
        val actual = problem.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        val expected = listOf(
            listOf("bat"),
            listOf("nat", "tan"),
            listOf("ate", "eat", "tea")
        )
        check(actual.size == expected.size) {
            "Test 1 failed: Expected result size ${expected.size}, but got ${actual.size}"
        }
        val sortedActual = actual.map { it.sorted() }.sortedBy { it.first() }
        val sortedExpected = expected.map { it.sorted() }.sortedBy { it.first() }
        sortedActual.zip(sortedExpected).forEachIndexed { index, (actualList, expectedList) ->
            check(actualList == expectedList) {
                "Test 1 failed: Mismatch at index $index. Expected: $expectedList, but got: $actualList"
            }
        }
    }
}
