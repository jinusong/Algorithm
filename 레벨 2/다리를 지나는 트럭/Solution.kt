data class Truck(val weight: Int, var second: Int = 0)

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val cross = ArrayList<Truck>()
        var cur_w = 0
        var time = 0
        var idx = 0

        while (!(cross.isEmpty() && idx >= truck_weights.size)) {

            if (!cross.isEmpty()) {
                for (truck in cross)
                    ++truck.second

                var front_truck = cross.first()

                if (front_truck.second >= bridge_length) {
                    cur_w -= front_truck.weight
                    cross.removeAt(0)
                }
            }
            if (idx < truck_weights.size && cur_w + truck_weights[idx] <= weight) {
                cross.add(Truck(truck_weights[idx]))
                cur_w += truck_weights[idx]
                ++idx
            }
            time++
        }

        return time
    }
}