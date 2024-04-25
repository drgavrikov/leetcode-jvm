import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
class Problem1423 {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var score = cardPoints.takeLast(k).sum()
        var maxScore = score
        (0 until k).forEach{
            score = score + cardPoints[it] - cardPoints[cardPoints.size - k + it]
            maxScore = max(maxScore, score)
        }
        return maxScore
    }
}

fun main() {
    val problem1423 = Problem1423()

    val actual1 = problem1423.maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3)
    check(actual1 == 12) { "Test 1 failed" }

    val actual2 = problem1423.maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7)
    check(actual2 == 55) { "Test 2 failed" }
}

