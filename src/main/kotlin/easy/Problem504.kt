package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/base-7/
 */
class Problem504 {
    fun convertToBase7(num: Int): String {
        var current = num
        var result = 0
        var pow = 1
        while (current != 0) {
            val tmp = current % 7
            result += tmp * pow
            pow *= 10
            current /= 7
        }
        return result.toString()
    }
}
