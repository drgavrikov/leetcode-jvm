/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class Problem14 {

    fun longestCommonPrefix(strs: Array<String>): String {
        var commonPrefix = 0
        while (strs.all { commonPrefix < it.length } && strs.map { it[commonPrefix] }.distinct().size == 1)
            commonPrefix++
        return strs[0].substring(0, commonPrefix)
    }
}
