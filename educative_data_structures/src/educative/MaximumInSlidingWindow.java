package educative;

import java.util.*;

import static educative.Pair.findMaxSlidingWindow2;

public class MaximumInSlidingWindow {
    public static List<Integer> findMaxSlidingWindow(int[] nums, int w) {
        List<Integer> output = new ArrayList<>();
        // we think about deque here because lets say we think about keeping window in array.. how will we rmoeve from first and add at last difficult to do so..
        // single queue same problem as we want the first and last element both we need to think about dequeue

        Deque<Integer> currWindow = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            if (currWindow.isEmpty() || currWindow.peekLast() > nums[i]) {
                currWindow.add(nums[i]);
            } else {
                while (!currWindow.isEmpty() && currWindow.peekLast() < nums[i]) {
                    currWindow.removeLast();
                }
                currWindow.add(nums[i]);
            }
            if (currWindow.size() > w) {
                output.add(currWindow.removeFirst());
            }

        }
        return output;
    }


    public static int[] findMaxInSlidingWindow(int[] nums, int w) {
        List<Integer> output = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);

        for (int i = 0; i < w; i++) {
            pq.add(new Pair(nums[i], i));
        }
        output.add(pq.peek().value);
        for (int i = w; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
            while (pq.peek().index <= i - w) {
                pq.poll();
            }
            output.add(pq.peek().value);

        }
        return output.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] input = new int[]{10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
        int window = 3;
        // System.out.println(findMaxSlidingWindow(input, window));
        System.out.println(Arrays.toString(findMaxSlidingWindow2(input, window)));
    }
}

class Pair {
    int index;
    int value;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public static int[] findMaxSlidingWindow2(int[] nums, int w) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < w; i++) {
            pq.add(new Pair(nums[i], i));
        }
        result.add(pq.peek().value);
        for (int i = w; i < nums.length; i++) {
            pq.offer(new Pair(nums[i], i));
            while (pq.peek().index <= i - w) {
                pq.poll();
            }
            result.add(pq.peek().value);
        }
        return result.stream().mapToInt(i -> i).toArray();


    }
}

