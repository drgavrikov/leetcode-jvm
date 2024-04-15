package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/backspace-string-compare/solutions/5028946/linear-solution-without-additional-memory/
 */
class Problem844 {
    private fun getNextIndex(s: String, index: Int): Int {
        var nextIndex = index
        var count = 0
        while (nextIndex >= 0) {
            if (s[nextIndex] == '#') count++
            else if (count > 0) count--
            else break
            nextIndex--
        }
        return nextIndex
    }

    fun backspaceCompare(s: String, t: String): Boolean {
        var index1 = getNextIndex(s, s.length - 1)
        var index2 = getNextIndex(t, t.length - 1)

        while (index1 > -1 && index2 > -1) {
            if (s[index1] != t[index2]) return false
            index1 = getNextIndex(s, index1 - 1)
            index2 = getNextIndex(t, index2 - 1)
        }
        return index1 == -1 && index2 == -1
    }
}

fun main() {
    val problem844 = Problem844()
    check(problem844.backspaceCompare("ab#c", "ad#c"))
    check(problem844.backspaceCompare("ab##", "c#d#"))
    check(!problem844.backspaceCompare("a#c", "b"))
}
