package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/string-compression/description/
 */
class Problem443 {

    fun compress(chars: CharArray): Int {
        var charIndex = 0
        var count = 1
        (1 .. chars.size).forEach { index ->
            if (index == chars.size || chars[index] != chars[index - 1]) {
                chars[charIndex++] = chars[index - 1]
                if (count > 1) count.toString().forEach { chars[charIndex++] = it }
                count = 1
            }
            else count++
        }
        return charIndex
    }
}
