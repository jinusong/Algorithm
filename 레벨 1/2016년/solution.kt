class Solution {
    fun solution(a: Int, b: Int): String {
        val month = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val week = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        var total = b + 4

        for(i in 0..a-2) total += month[i]

        return week[total%7]
    }
}