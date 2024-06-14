/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/solutions/5312102/one-line-solution-with-hash-map/
 */
class Problem2083 {
    fun numberOfSubstrings(s: String): Long {
        return s.toList()
            .groupingBy { it }
            .eachCount()
            .values
            .sumOf { count -> count * (count.toLong() + 1) / 2 }
    }
}

fun main() {
    val problem = Problem2083()

    check(problem.numberOfSubstrings("abcba") == 7L)
}
