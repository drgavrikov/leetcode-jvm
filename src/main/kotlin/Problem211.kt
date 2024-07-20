/**
 * @author Aleksandr Gavrikov
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/solutions/5471279/solution-with-trie-data-structure/
 */
class Problem211 {

    data class Node(
        val char: Char = '.',
        var isTerminal: Boolean = false,
        val children: MutableMap<Char, Node> = mutableMapOf()
    )

    private val root = Node()

    fun addWord(word: String) {
        var node = root
        word.forEach { ch: Char -> node = node.children.getOrPut(ch) { Node(ch) } }
        node.isTerminal = true
    }

    fun search(word: String, index: Int = 0, node: Node = root): Boolean {
        if (word.length == index) return node.isTerminal
        val char = word[index]
        return if (char != '.') node.children[char]?.let { search(word, index + 1, it) } ?: false
        else node.children.values.any { child -> search(word, index + 1, child) }
    }
}

fun main() {
    val problem = Problem211()
    problem.addWord("bad")
    problem.addWord("mad")
    problem.addWord("pad")
    problem.addWord("bad")
    check(problem.search(".ad"))
    check(problem.search("b.."))
}
