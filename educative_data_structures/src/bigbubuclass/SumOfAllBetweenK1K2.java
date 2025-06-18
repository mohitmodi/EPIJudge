package bigbubuclass;

import java.util.PriorityQueue;

public class SumOfAllBetweenK1K2 {
    public static void main(String[] args) {
        int arr[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        int k1 = 3;
        int k2 = 6;
        System.out.println(sumk1(arr, k1, k2));
    }

    private static int sumk1(int[] arr, int k1, int k2) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < k1; i++) {
            pq.poll();
        }
        int i = k2 - k1 - 1;
        while (i > 0) {
            if (!pq.isEmpty())
                sum += pq.poll();
            i--;
        }
        return sum;

    }

}
