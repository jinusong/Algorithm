class Solution {
    fun solution(s: String): String {
        var answer = ""
        var cnt = 0
        val array = s.split("".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()

        for (ss in array) {
            if (ss.contains(" ")) cnt =  0
            else cnt = cnt + 1

            if (cnt % 2 == 0) answer += ss.toLowerCase()
            else answer += ss.toUpperCase()
        }
        return answer
    }
}