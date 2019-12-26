import java.util.*
import kotlin.collections.ArrayList
import java.util.Comparator
import java.util.Arrays




class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""
        val arr = arrayOfNulls<String>(numbers.size)

        for (i in 0 until numbers.size) {
            arr[i] = numbers[i].toString()
        }

        Arrays.sort<String>(arr) { s1, s2 ->
            (s2 + s1).compareTo(s1 + s2)
        }

        if (arr[0] == "0") return "0"

        for (i in arr.indices) {
            answer += arr[i]
        }

        return answer
    }
}