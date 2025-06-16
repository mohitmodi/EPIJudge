package bigbubuclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestKNumbersInArray {
    //notdone
    public static void main(String[] args) {
        int arr[] = new int[]{15, 47, 13, 8, 10, 5, 2, 20, 3, 9, 11, 27};
        int k = 5;
        System.out.println(smallest1(arr, k));
    }

    private static List<Integer> smallest1(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }
        while (maxHeap.size() > k) {
            maxHeap.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            res.add(maxHeap.poll());
        }
        return res;
    }
}
