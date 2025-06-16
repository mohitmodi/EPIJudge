package educative;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//l1 2,6,8
//l2 3,6,10
//l3 5,8,11

public class KthLargestInMSortedLists {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        lists.forEach(minHeap::addAll);
        if (k > minHeap.size()) {
            while (minHeap.size() > 1) {
                minHeap.poll();
            }
        }else {
            while (k > 1) {
                minHeap.poll();
                k--;
            }
        }
        return minHeap.isEmpty() ? 0 : minHeap.peek();
    }

    public static void main(String[] args) {

        List<List<List<Integer>>> lists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(2, 6, 8),
                        Arrays.asList(3, 6, 10),
                        Arrays.asList(5, 8, 11)
                ),
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(6, 7, 8, 15),
                        Arrays.asList(10, 11, 12, 13),
                        Arrays.asList(5, 10)
                ),
                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(),
                        Arrays.asList()
                ),
                Arrays.asList(
                        Arrays.asList(1, 1, 3, 8),
                        Arrays.asList(5, 5, 7, 9),
                        Arrays.asList(3, 5, 8, 12)
                ),
                Arrays.asList(
                        Arrays.asList(5, 8, 9, 17),
                        Arrays.asList(),
                        Arrays.asList(8, 17, 23, 24)
                )
        );

        int[] k = {5, 50, 7, 4, 8};

        for (int i = 0; i < k.length; i++) {
            System.out.println(i + 1 + ".\t Input lists: " + lists.get(i) +
                    "\n\t K = " + k[i] +
                    "\n\t " + k[i] + "th smallest number from the given lists is: " +
                    kSmallestNumber(lists.get(i), k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
