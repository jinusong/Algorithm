import java.util.*


class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = HashMap<String, Int>()

        for (i in 0 until clothes.size) {
            val key = clothes[i][1]

            if (map.containsKey(key)) {
                map[key] = map[key]!! + 1
            } else {
                map[key] = 1
            }
        }

        val it = map.values.iterator()

        while (it.hasNext()) {
            answer *= it.next() + 1
        }
        return answer - 1
    }
}