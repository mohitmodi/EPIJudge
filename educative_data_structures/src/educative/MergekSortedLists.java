package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        lists=new ArrayList<>();
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<LinkedListNode> pq = new PriorityQueue<>(lists.size(), (a, b) -> a.data - b.data);
        for (LinkedList list : lists) {
            if (list != null) {
                pq.offer(list.head);
            }
        }
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode curr = head;
        while (!pq.isEmpty()) {
            LinkedListNode small = pq.poll();
            if (small != null) {

                curr.next = small;
                curr = small;
                if (small.next != null)
                    pq.offer(small.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {

        List<List<List<Integer>>> inputLists = Arrays.asList(
                Arrays.asList(new ArrayList<>()),
                Arrays.asList(Arrays.asList(21, 23, 42), Arrays.asList(1, 2, 4)),
                Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(21, 23, 42)),
                Arrays.asList(Arrays.asList(2), Arrays.asList(1, 2, 4), Arrays.asList(25, 56, 66, 72)),
                Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(2), Arrays.asList(2), Arrays.asList(2), Arrays.asList(1, 2, 4)),
                Arrays.asList(Arrays.asList(10, 30), Arrays.asList(15, 25), Arrays.asList(1, 7), Arrays.asList(3, 9), Arrays.asList(100, 300), Arrays.asList(115, 125), Arrays.asList(10, 70), Arrays.asList(30, 90))
        );
        for (int i = 0; i < inputLists.size(); i++) {
            System.out.println((i + 1) + ".\tInput lists:");
            List<LinkedList> llList = new ArrayList<>();
            for (List x : inputLists.get(i)) {
                LinkedList a = new LinkedList();
                a.createLinkedList(x);
                llList.add(a);
                System.out.print("\t");
                PrintList.printListWithForwardArrow(a.head);
                System.out.println();
            }
            System.out.print("\tMerged list: \n\t");
            PrintList.printListWithForwardArrow(mergeKLists(llList));
            //System.out.println("\n" + PrintHyphens.repeat("-", 100));
        }
    }

}
