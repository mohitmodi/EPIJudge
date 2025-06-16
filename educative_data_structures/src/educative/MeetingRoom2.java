package educative;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static int findSets(int[][] intervals) {
        Arrays.sort(intervals, (Comparator<int[]>) (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            if (minHeap.isEmpty()) {
                minHeap.add(endTime);
            } else if (minHeap.peek() <= startTime) {
                minHeap.poll();
                minHeap.add(endTime);
            } else {
                minHeap.add(endTime);
            }
        }
        return minHeap.size();
    }
}
