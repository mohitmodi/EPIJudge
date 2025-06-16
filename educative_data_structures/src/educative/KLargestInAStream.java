package educative;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestInAStream {
    PriorityQueue<Integer> minHeap;
    int k;

    KLargestInAStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
    }


    private int add(int i) {
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        if (minHeap.size() == k) {
            if (i > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(i);
            }
        } else {
            minHeap.add(i);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 10};
        int[] temp = {3, 6, 9, 10};
        System.out.print("Initial stream: ");
        printArray(nums);
        System.out.println("\nk: " + 3);
        KLargestInAStream kLargest = new KLargestInAStream(3, nums);
        int[] val = {4, 7, 10, 8, 15};
        for (int i = 0; i < val.length; i++) {
            System.out.println("\tAdding a new number " + val[i] + " to the stream");
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = val[i];
            System.out.print("\tNumber stream: ");
            printArray(temp);
            System.out.println("\n\tKth largest element in the stream: " + kLargest.add(val[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
