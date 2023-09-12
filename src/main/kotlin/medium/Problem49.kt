package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/group-anagrams/
 */
class Problem49 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs
            .groupBy { str -> str.groupingBy { it }.eachCount() }
            .values
            .toList()
    }
}
