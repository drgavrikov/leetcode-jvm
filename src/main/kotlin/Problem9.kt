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
