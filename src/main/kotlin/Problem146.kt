/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/lru-cache/submissions/1208518666/
 */
class Problem146 {

    class LRUCache(capacity: Int) {

        private val cap = capacity

        class Node(
            val key: Int,
            var value: Int,
            var prev: Node?,
            var next: Node?
        )

        private val cache = mutableMapOf<Int, Node>()
        private var head: Node? = null
        private var tail: Node? = null

        private fun addHead(node: Node) {
            if (head == null) {
                head = node
                tail = node
            } else {
                node.prev = null
                node.next = head
                head?.prev = node
                head = node
            }
            cache.put(node.key, node)
        }

        private fun remove(node: Node) {
            if (node == head) {
                val temp = head
                head = head?.next
                head?.prev = null
                temp?.next = null
            } else if (node == tail) {
                val temp = tail
                tail = tail?.prev
                tail?.next = null
                temp?.prev = null
            } else {
                val prev = node.prev
                val next = node.next
                prev?.next = next
                next?.prev = prev
                node.prev = null
                node.next = null
            }
            cache.remove(node.key)
        }

        fun get(key: Int): Int {
            if (key !in cache) return -1
            val node = cache.getValue(key)
            remove(node)
            addHead(node)
            return node.value
        }

        fun put(key: Int, value: Int) {
            if (key in cache) remove(cache.getValue(key))
            if (cache.size >= cap) remove(tail!!)
            val newNode = Node(key, value, null, null)
            addHead(newNode)
        }
    }
}

fun main() {
    val lruCache = Problem146.LRUCache(2)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    check(lruCache.get(1) == 1)
    lruCache.put(3, 3)
    check(lruCache.get(2) == -1)
    lruCache.put(4, 4)
    check(lruCache.get(1) == -1)
    check(lruCache.get(3) == 3)
    check(lruCache.get(4) == 4)
}