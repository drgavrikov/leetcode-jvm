/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/palindrome-number/
 */
class Problem9 {
    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        val len = str.length
        for (index in 1..len / 2) {
            if (str[index] != str[len - index - 1]) return false
        }
        return true
    }
}

fun main() {
    val problem9 = Problem9()

    val actual1 = problem9.isPalindrome(121)
    check(actual1) { "Test failed: Expected true, actual: $actual1" }

    val actual2 = problem9.isPalindrome(-121)
    check(!actual2) { "Test failed: Expected false, actual: $actual2" }
}

