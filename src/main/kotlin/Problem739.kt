/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/daily-temperatures/solutions/5053738/iterating-backwards-solution-without-stack-and-additional-memory/
 */
class Problem739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val result = IntArray(n) {0}

        var hottest = 0
        for (index in (n - 1) downTo 0) {
            val temperature = temperatures[index]
            if (temperature >= hottest) {
                hottest = temperature
                continue
            }
            var days = 1
            while (temperatures[index + days] <= temperature) days += result[index + days]
            result[index] = days
        }
        return result
    }
}

fun main() {
    val problem = Problem739()
    val actual = problem.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
    check(actual.contentEquals(intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)))
}
