import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var time = 0
        var nowWeight = weight
        val waitTruckQueue = LinkedList<Truck>()
        val trucksOnBridge = ArrayList<Truck>()

        for (trucks in truck_weights) {
            waitTruckQueue.add(Truck(trucks, bridge_length))
        }

        while (waitTruckQueue.isNotEmpty() || trucksOnBridge.isNotEmpty()) {
            if (trucksOnBridge.isNotEmpty() && trucksOnBridge.first().second <= 0) {
                nowWeight += trucksOnBridge.first().weight
                trucksOnBridge.removeAt(0)
            }

            if (waitTruckQueue.isNotEmpty() && nowWeight - waitTruckQueue.peek().weight >= 0) {
                nowWeight -= waitTruckQueue.peek().weight
                trucksOnBridge.add(waitTruckQueue.poll())
            }

            trucksOnBridge.forEach { item ->
                item.second--
            }

            time++
        }
        return time
    }

}

data class Truck(val weight: Int, var second: Int)


fun main(args: Array<String>) {
    print(Solution().solution(2, 10, intArrayOf(7, 4, 5, 6)))

}