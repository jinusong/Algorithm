import java.util.*
import java.util.LinkedList
import java.util.ArrayList



class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val resultList = ArrayList<Int>()

        val progressesQueue: Queue<Int> = LinkedList(progresses.toList())
        val speedsQueue: Queue<Int> = LinkedList(speeds.toList())

        while (progressesQueue.isNotEmpty()) {
            val dateCount = Math.ceil(
                    (100 - progressesQueue.peek()).toDouble() / speedsQueue.peek().toDouble())
            var pollCount = 0

            while (progressesQueue.isNotEmpty()
                    && progressesQueue.peek() + (speedsQueue.peek() * dateCount) >= 100) {
                progressesQueue.poll()
                speedsQueue.poll()
                pollCount++
            }
            resultList.add(pollCount)
        }

        return resultList.toIntArray()
    }
}