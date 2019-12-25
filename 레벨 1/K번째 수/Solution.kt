import java.util.*


class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = ArrayList<Int>()

        commands.forEach {
            val subArray = ArrayList<Int>()

            for (i in (it[0] - 1)..(it[1] - 1)) {
                subArray.add(array[i])
            }
            subArray.sort()
            answer.add(subArray[it[2] - 1])
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    Solution().solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))).forEach {
        print("$it, ")
    }
}