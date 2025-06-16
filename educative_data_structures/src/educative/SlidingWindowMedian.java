package educative;

import java.util.*;

public class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();
        PriorityQueue<Pair1> minHeap = new PriorityQueue<>(new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                return o1.value - o2.value;
            }
        });
        PriorityQueue<Pair1> maxHeap = new PriorityQueue<>(new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                return o2.value - o1.value;
            }
        });
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(new Pair1(i, nums[i]));
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.offer(new Pair1(i, nums[i]));
                maxHeap.add(minHeap.poll());
            }
            counter++;
            if (counter >= k) {
                if (k % 2 == 0) {
                    result.add((minHeap.peek().value + maxHeap.peek().value) * 0.5);
                } else {
                    result.add((double) minHeap.peek().value);
                }
                if (maxHeap.peek().index <= i - k) {
                    maxHeap.poll();
                }
                if (minHeap.peek().index <= i - k) {
                    minHeap.poll();
                }
            }
        }


        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        int p[] = new int[]{4, 7, 2, 21};
        int k = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(p, k)));
    }
}

class Pair1 {
    int index;
    int value;

    Pair1(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
