package netflix;

import java.util.Collections;
import java.util.PriorityQueue;

public class Feature3 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    Feature3() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void insert(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((minHeap.size() == maxHeap.size())) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Feature3 f = new Feature3();
        f.insert(22);
        f.insert(35);
        f.insert(30);
        System.out.println(f.findMedian());
        f.insert(25);
        System.out.println(f.findMedian());
    }


}
