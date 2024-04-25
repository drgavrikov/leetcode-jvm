/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-palindromic-substring/description/
 */
class Problem5 {

    fun longestPalindrome(s: String): String {
        fun expandPalindrome(left: Int, right: Int): Pair<Int, Int> {
            var nextLeft = left
            var nextRight = right
            while (nextLeft - 1 >= 0 && nextRight + 1 < s.length && s[nextLeft - 1] == s[nextRight + 1]) {
                nextLeft--
                nextRight++
            }
            return Pair(nextLeft, nextRight)
        }

        val oddIndices = s.indices.map { index -> expandPalindrome(index, index) }
        val evenIndices = (0 until s.length - 1)
            .filter { index -> s[index] == s[index + 1] }
            .map { index -> expandPalindrome(index, index + 1) }
        val best = (oddIndices + evenIndices).maxByOrNull { (left, right) -> right - left + 1 }!!
        return s.substring(best.first, best.second + 1)
    }
}

fun main() {
    val problem = Problem5()

    val actual = problem.longestPalindrome("babad")
    check(actual == "bab") { "Expected 'bab', but got: $actual" }
}
