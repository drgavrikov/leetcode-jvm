/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/count-substrings-without-repeating-character/solutions/5353968/sliding-window-without-additional-memory/
 */
class Problem2743 {
    fun numberOfSpecialSubstrings(s: String): Int {
        var count = 0
        val frequencies = HashMap<Char, Int>()
        var countNotUnique = 0

        var left = 0
        for (right in s.indices) {
            frequencies[s[right]] = frequencies.getOrDefault(s[right], 0) + 1
            if (frequencies.getValue(s[right]) == 2) countNotUnique++
            while (countNotUnique > 0) {
                frequencies[s[left]] = frequencies.getValue(s[left]) - 1
                if (frequencies.getValue(s[left]) == 1) countNotUnique--
                left++
            }
            count += right - left + 1
        }
        return count
    }
}

fun main() {
    val problem = Problem2743()
    check(problem.numberOfSpecialSubstrings("abcd") == 10)
}
