package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/di-string-match/description/
 */
class Problem942 {

    fun diStringMatch(s: String): IntArray {
        var i = 0
        var d = s.length
        return (s.map { char -> if (char == 'I') i++ else d-- } + i).toIntArray()
    }
}
