package educative;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void insertNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());

        }
    }

    public double findMedian() {
        if (maxHeap.size() != minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        // Driver code
        int[] nums = {1, 2, 3};
        MedianFromDataStream medianOfAges = null;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianFromDataStream();
            for (int j = 0; j <= i; j++) {
                System.out.print(nums[j]);
                if (j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
            // System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
