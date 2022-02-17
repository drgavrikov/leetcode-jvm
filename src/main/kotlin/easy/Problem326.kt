package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/single-number/
 */
class Problem326 {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false
        var x = n
        while (x % 3 == 0) x /= 3
        return x == 1 || x == -1
    }
}
