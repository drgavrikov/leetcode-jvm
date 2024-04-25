/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-binary-string-after-change/solutions/5003023/solution-in-linear-time/
 */
class Problem1702 {

    fun maximumBinaryString(binary: String): String {
        val firstZero = binary.indexOfFirst { it == '0' }
        if (firstZero == -1) return binary

        val countZeros = binary.drop(firstZero).count { it == '0' }
        val countOnes = binary.length - firstZero - countZeros

        val result =
            (0 until firstZero).map { '1' } +
            (0 until (countZeros - 1)).map { '1' } +
            '0' +
            (0 until (countOnes)).map { '1' }
        return result.joinToString("")
    }
}

fun main() {
    val problem = Problem1702()
    check("111011" == problem.maximumBinaryString("000110"))
}
