import java.util.*
import kotlin.collections.ArrayList


class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = ArrayList<Int>()
        val firstStudentAnswers = arrayListOf(1, 2, 3, 4, 5)
        val secondStudentAnswers = arrayListOf(2, 1, 2, 3, 2, 4, 2, 5)
        val thirdStudentAnswers = arrayListOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var firstStudentCount = 0
        var secondStudentCount = 0
        var thirdStudentCount = 0


        for (i in 0 until answers.size) {
            firstStudentCount =
                    if (i >= 5) checkAnswer(firstStudentCount, answers[i], firstStudentAnswers[i%5])
                    else checkAnswer(firstStudentCount, answers[i], firstStudentAnswers[i])

            secondStudentCount =
                    if (i >= 8) checkAnswer(secondStudentCount, answers[i], secondStudentAnswers[i%8])
                    else checkAnswer(secondStudentCount, answers[i], secondStudentAnswers[i])

            thirdStudentCount =
                    if (i >= 10) checkAnswer(thirdStudentCount, answers[i], thirdStudentAnswers[i%10])
                    else checkAnswer(thirdStudentCount, answers[i], thirdStudentAnswers[i])
        }

        val max = Math.max(firstStudentCount, Math.max(secondStudentCount, thirdStudentCount))

        if (max == firstStudentCount) answer.add(1)
        if (max == secondStudentCount) answer.add(2)
        if (max == thirdStudentCount) answer.add(3)

        return answer.toIntArray()
    }

    private fun checkAnswer(nowCount: Int, answer: Int, studentAnswer: Int): Int {
        if (answer == studentAnswer)
            return nowCount + 1

        return nowCount
    }
}

fun main(args: Array<String>) {
    Solution().solution(intArrayOf(1,2,3,4,5)).forEach {
        print(it)
    }
}