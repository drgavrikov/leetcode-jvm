import java.util.*
import kotlin.math.max

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/maximum-frequency-stack/
 */
class Problem895 {
    class FreqStack {
        private val frequencies = mutableMapOf<Int, Int>()
        private val storage = mutableMapOf<Int, Stack<Int>>()
        private var maxFrequency = -1

        fun push(`val`: Int) {
            frequencies.putIfAbsent(`val`, 0)
            val frequency = frequencies.getValue(`val`)
            val nextFrequency = frequency + 1
            frequencies[`val`] = nextFrequency
            maxFrequency = max(maxFrequency, nextFrequency)

            storage.putIfAbsent(nextFrequency, Stack())
            storage.getValue(nextFrequency).add(`val`)
        }

        fun pop(): Int {
            val result = storage.getValue(maxFrequency).pop()!!
            frequencies[result] = frequencies.getValue(result) - 1
            if (storage.getValue(maxFrequency).isEmpty()) maxFrequency--
            return result
        }
    }
}
