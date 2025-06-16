package educative;

import java.util.Collections;
import java.util.PriorityQueue;

public class Klargest {


    public static void kLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (min.size() == max.size()) {
                max.offer(nums[i]);
                min.offer(max.poll());
            } else {
                min.offer(nums[i]);
                max.offer(min.poll());
            }
            if (!min.isEmpty() && !max.isEmpty()) {
                if (min.size() == max.size()) {
                    System.out.println((min.peek() + max.peek()) / 2.0);
                } else {
                    System.out.println(min.peek());
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{35, 22, 30, 25, 1};
        kLargest(nums, 3);
    }

    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
