class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var exp = name.length - 1
        for (i in 0 until name.length) {
            val alphabet = name[i]

            answer += if ('Z' - alphabet + 1 > alphabet - 'A') alphabet - 'A' else 'Z' - alphabet + 1

            if (alphabet == 'A') {
                var nextIdx = i + 1
                var countA = 0
                while (nextIdx < name.length && name[nextIdx] == 'A') {
                    countA++
                    nextIdx++
                }
                val tmp = (i - 1) * 2 + (name.length - 1 - i - countA)
                if (exp > tmp) exp = tmp
            }
        }

        answer += exp
        return answer
    }
}

fun main(args: Array<String>) {

}