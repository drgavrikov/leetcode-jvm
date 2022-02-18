package medium

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
