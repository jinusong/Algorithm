import java.util.*


class Solution {
    fun solution(heights: IntArray): IntArray {
        val answer = ArrayList<Int>()
        val heightsStack = Stack<Int>()

        heights.forEach {
            heightsStack.push(it)
        }

        while (heightsStack.isNotEmpty()) {
            val top = heightsStack.pop()
            var lastIndex = -1

            for (i in 0 until heightsStack.size) {
                if (heightsStack[i] > top) {
                    lastIndex = i
                }
            }
            answer.add(lastIndex + 1)
        }

        return answer.reversed().toIntArray()
    }
}

fun main(args: Array<String>) {
    Solution().solution(intArrayOf(6,9,5,7,4)).forEach {
        print("$it, ")
    }
}