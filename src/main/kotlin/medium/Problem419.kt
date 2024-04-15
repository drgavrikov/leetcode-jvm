package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/battleships-in-a-board/solutions/5028822/solution-in-one-iteration-through-the-matrix-without-using-additional-memory/
 */
class Problem419 {

    fun countBattleships(board: Array<CharArray>): Int {
        var result = 0
        val n = board.size
        val m = board[0].size
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (
                    board[i][j] == 'X' &&
                    (i == 0 || board[i - 1][j] == '.') &&
                    (j == 0 || board[i][j - 1] == '.')
                ) result++
            }
        }
        return result
    }
}

fun main() {
    val problem = Problem419()
    val actual = problem.countBattleships(
        arrayOf(
            charArrayOf('X', '.', '.', 'X'),
            charArrayOf('.', '.', '.', 'X'),
            charArrayOf('.', '.', '.', 'X')
        )
    )
    check(actual == 2)
}
