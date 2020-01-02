import java.util.*

data class Song(val idx: Int, val plays: Int) : Comparable<Song> {
    override fun compareTo(o: Song): Int {
        return if (this.plays == o.plays) {
            if (this.idx > o.idx) 1
            else -1
        } else if (this.plays < o.plays) 1
        else -1
    }
}

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val rankHash = HashMap<String, Int>()
        plays.indices.forEach {
            rankHash[genres[it]] = rankHash.getOrDefault(genres[it], 0) + plays[it]
        }

        val pq = PriorityQueue<Int> { x, y -> y!! - x!! }
        rankHash.values.forEach { pq.add(it) }

        val rankHashReverse = HashMap<Int, String>()
        rankHash.keys.forEach { rankHashReverse[rankHash[it]!!] = it }

        val rankArr = arrayOfNulls<String>(pq.size)
        for (i in 0 until pq.size) {
            rankArr[i] = rankHashReverse[pq.poll()]
        }

        val songsRank = HashMap<String, PriorityQueue<Song>>()
        for (i in plays.indices) {
            if (songsRank.containsKey(genres[i])) {
                songsRank[genres[i]]!!.add(Song(i, plays[i]))
            } else {
                songsRank[genres[i]] = PriorityQueue()
                songsRank[genres[i]]!!.add(Song(i, plays[i]))
            }
        }

        val answerArrList = ArrayList<Int>()
        rankArr.forEach {
            answerArrList.add(songsRank[it]!!.poll().idx)
            if (songsRank[it]!!.peek() != null) {
                answerArrList.add(songsRank[it]!!.poll().idx)
            }
        }

        return answerArrList.toIntArray()
    }
}


fun main(args: Array<String>) {
    Solution().solution(
            arrayOf("classic", "pop", "classic", "classic", "pop"),
            intArrayOf(500, 600, 150, 800, 2500)
    ).forEach {
        print("$it, ")
    }
}