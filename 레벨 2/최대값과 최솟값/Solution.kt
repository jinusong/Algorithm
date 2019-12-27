class Solution {
    fun solution(s: String): String {
        var answer = ""
        var sArrayList = ArrayList(
                s.split(" ").toTypedArray().map {
                    it.toInt()
                })

        sArrayList.sort()

        answer = "${sArrayList[0]} ${sArrayList[sArrayList.lastIndex]}"

        return answer
    }
}

fun main(args: Array<String>) {

}