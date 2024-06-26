/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-and-replace-in-string/
 */
class Problem833 {

    class Token(
        val index: Int,
        val source: String,
        val target: String,
    ) {
        fun check(s: String) = source.indices.all { index + it < s.length && s[index + it] == source[it] }
    }

    fun findReplaceString(
        s: String,
        indices: IntArray,
        sources: Array<String>,
        targets: Array<String>
    ): String {

        val tokens = indices
            .mapIndexed { index, i -> Token(i, sources[index], targets[index]) }
            .groupBy { it.index }
            .toMap()

        var i = 0
        val result = StringBuffer("")
        while (i < s.length) {
            if (i in tokens) {
                val token = tokens.getValue(i).firstOrNull { token -> token.check(s) }
                if (token != null) {
                    val target = token.target
                    result.append(target)
                    i += token.source.length
                } else result.append(s[i++])
            } else result.append(s[i++])
        }
        return result.toString()
    }
}

fun main() {
    val problem833 = Problem833()

    val actual1 = problem833.findReplaceString(
        "abcd",
        intArrayOf(0, 2),
        arrayOf("a", "cd"),
        arrayOf("eee", "ffff"),
    )
    check(actual1 == "eeebffff") { "Test 1 failed" }

    val actual2 = problem833.findReplaceString(
        "abcd",
        intArrayOf(0, 2),
        arrayOf("ab", "ec"),
        arrayOf("eee", "ffff"),
    )
    check(actual2 == "eeecd") { "Test 2 failed" }

    val actual3 = problem833.findReplaceString(
        "abcde",
        intArrayOf(2, 2),
        arrayOf("cde", "cdef"),
        arrayOf("fe", "f"),
    )
    check(actual3 == "abfe") { "Test 3 failed" }
}
