/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/minimum-increment-to-make-array-unique/solutions/5768013/greedy-solution/
 */
class Problem945 {
    fun minIncrementForUnique(nums: IntArray): Int {
        val max = nums.maxOf { it }
        val frequencies = IntArray(nums.size + max) { 0 }
        nums.forEach { num -> frequencies[num]++ }
        var result = 0
        for (num in 0 until  nums.size + max - 1) {
            if (frequencies[num] <= 1) continue

            val duplicates = frequencies[num] - 1
            frequencies[num + 1] += duplicates
            frequencies[num] = 1

            result += duplicates
        }
        return result
    }
}

fun main() {
    val problem = Problem945()
    check(problem.minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)) == 6)
    check(problem.minIncrementForUnique(intArrayOf(0, 0)) == 1)
}
