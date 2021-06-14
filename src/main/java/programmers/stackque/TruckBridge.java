package programmers.stackque;

import myutil.Util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class TruckBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        Queue<Truck> truckQueue = new LinkedList<>();

        truckQueue.add(new Truck(1, truck_weights[0]));
        int totalWeight = truck_weights[0];
        int truckIdx = 1;
        while (truckQueue.isEmpty() == false) {
            time++;
            Truck firstTruck = truckQueue.peek();
            if (time - firstTruck.startTime == bridge_length) {
                truckQueue.poll();
                totalWeight -= firstTruck.weight;
            }

            if (truckIdx < truck_weights.length && totalWeight + truck_weights[truckIdx] <= weight) {
                truckQueue.add(new Truck(time, truck_weights[truckIdx]));
                totalWeight += truck_weights[truckIdx++];
            }
        }

        return time;
    }

    class Truck {
        int startTime;
        int weight;

        Truck(int startTime, int weight) {
            this.startTime = startTime;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        TruckBridge p = new TruckBridge();

        int t = 1;
        t = Util.getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            Util.print(p.solution(Util.getInt(), Util.getInt(), Util.getIntArray()));
        }
    }
}
