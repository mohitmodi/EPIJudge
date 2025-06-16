package educative;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int maxCapital = c;
        PriorityQueue<Integer> capitalMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> profitMaxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int capital : capitals) {
            capitalMinHeap.add(capital);
        }
        if (capitalMinHeap.peek() > maxCapital) {
            return maxCapital;
        }



        return maxCapital;
    }
}
