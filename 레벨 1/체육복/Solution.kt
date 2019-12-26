class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size

        for (i in reserve.indices) {
            for (j in lost.indices) {

                if (lost[j] == -10 && reserve[i] == -10) {
                    continue
                }

                if (lost[j] == reserve[i]) {
                    lost[j] = -10
                    reserve[i] = -10
                    answer++
                }
            }
        }
        for (i in lost.indices) {
            for (j in reserve.indices) {
                if (lost[i] == -10 || reserve[j] == -10) {
                    continue
                }

                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    answer++
                    reserve[j] = -10
                    break
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {

}