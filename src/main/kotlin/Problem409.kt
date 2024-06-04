/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-palindrome/solutions/5258509/counting-the-frequencies-solution/
 */
class Problem409 {
    fun longestPalindrome(s: String): Int {
        val letterCount = IntArray('z' - 'A' + 1) { 0 }
        var oddCount = 0
        s.forEach { char ->
            ++letterCount[char - 'A']
            if (letterCount[char - 'A'] % 2 != 0) oddCount++
            else oddCount--
        }
        return letterCount.sumOf { (it shr 1) shl 1 } + (if (oddCount > 0) 1 else 0)
    }
}

fun main() {
    val problem = Problem409()
    check(problem.longestPalindrome("abccccdd") == 7)
}

