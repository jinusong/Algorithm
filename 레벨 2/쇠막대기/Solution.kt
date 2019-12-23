import java.util.*

class Solution {
    fun solution(arrangement: String): Int {
        var answer: Int = 0
        val stack = Stack<Char>()
        val str = arrangement.replace("()", "0")

        str.forEach {
            when (it) {
                '0' -> {
                    answer += stack.size
                }
                '(' -> {
                    stack.push(it)
                }
                ')' -> {
                    stack.pop()
                    answer += 1
                }
            }
        }
        return answer
    }
}