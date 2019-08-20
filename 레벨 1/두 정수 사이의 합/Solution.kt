class Solution {
    fun solution(a: Int, b: Int): Long {
        val aLong = a.toLong()
        val bLong = b.toLong()

        if (a < b) return add(aLong, bLong)
        return add(bLong, aLong)
    }

    fun add(a: Long, b: Long): Long {
        val n = Math.abs(a-b)+1

        return (a+b)*n/2
    }
}