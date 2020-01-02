import java.util.*

class Solution {
    fun solution(brown: Int, red: Int): IntArray {
        for (y in 3..red + 2) {
            var x = y
            while (x * 2 + (y - 2) * 2 <= brown) {
                if ((x - 2) * (y - 2) == red) {
                    return intArrayOf(x, y)
                }
                x++
            }
        }

        return intArrayOf(brown, red)
    }
}


fun main(args: Array<String>) {
}