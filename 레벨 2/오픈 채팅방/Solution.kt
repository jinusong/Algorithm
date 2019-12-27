
import java.util.LinkedList
import java.util.HashMap

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val idMap = HashMap<String, String>()
        val tmp = LinkedList<Array<String>>()

        for (records in record) {
            val keyWord = records.split(" ").toTypedArray()
            when {
                keyWord[0] == "Enter" -> {
                    idMap[keyWord[1]] = keyWord[2]
                    tmp.add(keyWord)
                }

                keyWord[0] == "Change" -> idMap[keyWord[1]] = keyWord[2]

                else -> tmp.add(keyWord)
            }
        }

        val answer = arrayOfNulls<String>(tmp.size)
        var idx = 0

        for (keyWords in tmp) {
            val nickName = idMap[keyWords[1]]
            if (keyWords[0] == "Enter")
                answer[idx++] = nickName + "님이 들어왔습니다."
            else
                answer[idx++] = nickName + "님이 나갔습니다."
        }
        return answer.requireNoNulls()
    }
}

fun main(args: Array<String>) {
    Solution().solution(
            arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")).forEach {
        println(it)
    }
}