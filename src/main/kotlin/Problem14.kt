/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/longest-common-prefix/submissions/
 */
class Problem14 {

    fun longestCommonPrefix(strs: Array<String>): String {
        var commonPrefix = 0
        while (strs.all { commonPrefix < it.length } && strs.map { it[commonPrefix] }.distinct().size == 1)
            commonPrefix++
        return strs[0].substring(0, commonPrefix)
    }
}

fun main() {
    val problem14 = Problem14()

    val actual1 = problem14.longestCommonPrefix(arrayOf("flower", "flow", "flight"))
    check(actual1 == "fl") { "Test failed: Expected 'fl', actual: '$actual1'" }

    val actual2 = problem14.longestCommonPrefix(arrayOf("dog", "racecar", "car"))
    check(actual2 == "") { "Test failed: Expected empty string, actual: '$actual2'" }
}
