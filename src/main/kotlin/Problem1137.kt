/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/n-th-tribonacci-number/solutions/5067835/dynamic-programming-without-additional-memory/
 */
class Problem1137 {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1

        var t0 = 0
        var t1 = 1
        var t2 = 1
        repeat(n - 2) {
            val temp = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = temp
        }
        return t2
    }
}

fun main() {
    val problem = Problem1137()
    check(problem.tribonacci(0) == 0)
    check(problem.tribonacci(1) == 1)
    check(problem.tribonacci(4) == 4)
    check(problem.tribonacci(25) == 1389537)
}
