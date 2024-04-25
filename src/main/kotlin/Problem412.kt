/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/fizz-buzz/
 */
class Problem412 {
    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map {
            when {
                (it % 15 == 0) -> "FizzBuzz"
                (it % 3 == 0) -> "Fizz"
                (it % 5 == 0) -> "Buzz"
                else -> it.toString()
            }
        }.toList()
    }
}

fun main() {
    val problem412 = Problem412()

    runDynamicTest("test1") {
        val actual = problem412.fizzBuzz(15)
        val result = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
        )
        check(actual == result) { "Test failed: Expected $result, actual: $actual" }
    }
}
