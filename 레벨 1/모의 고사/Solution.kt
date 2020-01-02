import java.util.*

class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        val firstArrayList = arrayListOf(1, 2, 3, 4, 5)
        val secondArrayList = arrayListOf(2, 1, 2, 3, 2, 4, 2, 5)
        val thirdArrayList = arrayListOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val countArrayList = arrayListOf(0, 0, 0)

        for(i in 0 until answers.size) {
            if(i>=5) {
                if(firstArrayList[i%5] == answers[i])
                    countArrayList[0]++
            } else {
                if(firstArrayList[i] == answers[i])
                    countArrayList[0]++
            }
            if(i>=8) {
                if(secondArrayList[i%8] == answers[i])
                    countArrayList[1]++
            } else {
                if(secondArrayList[i] == answers[i])
                    countArrayList[1]++
            }
            if(i>=10) {
                if(thirdArrayList[i%10] == answers[i])
                    countArrayList[2]++
            } else {
                if(thirdArrayList[i] == answers[i])
                    countArrayList[2]++
            }
        }

        var max = 0

        for(i in 0 until countArrayList.size) {
            if(max < countArrayList[i]) {
                max = countArrayList[i]
                answer = arrayListOf(i+1)
            }
            else if(max == countArrayList[i]) {
                answer.add(i+1)
            }
        }

        return answer.toIntArray()
    }
}


fun main(args: Array<String>) {
}