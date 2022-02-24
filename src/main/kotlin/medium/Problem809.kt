package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/expressive-words/
 */
class Problem809 {
    fun expressiveWords(s: String, words: Array<String>): Int {
        fun split(s: String): List<String> {
            val result = mutableListOf<String>()
            var from = 0
            var to = from
            while (from < s.length) {
                while (to < s.length && s[to] == s[from]) to++
                result.add(s.substring(from, to))
                from = to
            }
            return result.toList()
        }

        fun isExpressive(s: String, word: String): Boolean {
            val splitS = split(s)
            val splitWord = split(word)
            if (splitS.size != splitWord.size) return false

            for (index in splitS.indices) {
                if (splitWord[index][0] != splitS[index][0]) return false
                if (splitWord[index] > splitS[index]) return false
                if (splitWord[index].length == 1 && splitS[index].length == 2) return false
            }
            return true
        }
        return words.count { word -> isExpressive(s, word) }
    }
}
