
import java.util.ArrayList
import java.util.HashSet
import java.util.Stack





class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        citations.sort()

        var size = 0

        citations.forEach {
            if (it >= citations.size - size) {
                answer = citations.size - size
                return answer
            }
            size++
        }

        return answer
    }
}