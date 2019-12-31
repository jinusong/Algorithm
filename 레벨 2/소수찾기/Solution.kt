
import java.util.ArrayList
import java.util.HashSet



class Solution {

    fun solution(numbers: String): Int {
        var answer = 0

        val num_arr = numbers.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        val checked = HashSet<Int>()

        for (i in num_arr.indices) {
            answer += makeNum(num_arr, checked, "", 0, i + 1)
        }

        return answer
    }

    private fun makeNum(arr: Array<String>, checked: HashSet<Int>, numString: String, visited: Int, toPick: Int): Int {

        if (toPick == 0) {
            val num = Integer.parseInt(numString)

            if (checked.contains(num)) return 0

            checked.add(num)

            return if (isPrime(num)) 1 else 0
        }

        var ret = 0

        for (i in arr.indices) {
            if (visited and (1 shl i) > 0)
                continue
            ret += makeNum(arr, checked, numString + arr[i], visited + (1 shl i), toPick - 1)
        }

        return ret
    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 1) return false
        if (num == 2) return true

        if (num % 2 == 0) return false

        val sqrtn = Math.sqrt(num.toDouble()).toInt()
        var i = 3

        while (i <= sqrtn) {
            if (num % i == 0) return false
            i += 2
        }
        return true
    }
}