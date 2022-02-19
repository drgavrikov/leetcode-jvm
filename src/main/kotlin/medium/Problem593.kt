package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/valid-square/
 */
class Problem593 {
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        val ps = listOf(p1, p2, p3, p4).sortedWith(compareBy({ it[0] }, { it[1] }))
        if (ps[0].contentEquals(ps[1]) || ps[1].contentEquals(ps[2]) || ps[2].contentEquals(ps[3])) return false
        return isSquare(ps[0], ps[1], ps[2], ps[3]) ||
                isSquare(ps[0], ps[1], ps[3], ps[2]) ||
                isSquare(ps[0], ps[2], ps[1], ps[3]) ||
                isSquare(ps[0], ps[2], ps[3], ps[1]) ||
                isSquare(ps[0], ps[3], ps[1], ps[2]) ||
                isSquare(ps[0], ps[3], ps[2], ps[1])
    }

    private fun isSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        fun squareDistance(p: IntArray, q: IntArray): Int {
            return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1])
        }
        return squareDistance(p1, p2) == squareDistance(p2, p3) &&
                squareDistance(p2, p3) == squareDistance(p3, p4) &&
                squareDistance(p3, p4) == squareDistance(p4, p1) &&
                squareDistance(p1, p3) == squareDistance(p2, p4)
    }
}
