package netflix;

import educative.LinkedListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Feature2 {

    public static netflix.LinkedListNode mergeKCounty(List<netflix.LinkedListNode> lists) {
        netflix.LinkedListNode dummy = new netflix.LinkedListNode(-1);
        netflix.LinkedListNode curr = dummy;
        PriorityQueue<netflix.LinkedListNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (netflix.LinkedListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        while (!minHeap.isEmpty()) {
            netflix.LinkedListNode min = minHeap.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                minHeap.add(min.next);
            }
        }
        return dummy.next;
    }

    public static netflix.LinkedListNode merge2County(netflix.LinkedListNode list1, netflix.LinkedListNode list2) {
        netflix.LinkedListNode dummy = new netflix.LinkedListNode(-1);
        netflix.LinkedListNode curr = dummy;
        netflix.LinkedListNode curr1 = list1;
        netflix.LinkedListNode curr2 = list2;

        while (curr1 != null && curr2 != null) {
            if (curr1.data > curr2.data) {
                curr.next = curr2;
                curr2 = curr2.next;
            } else {
                curr.next = curr1;
                curr1 = curr1.next;
            }
            curr=curr.next;
        }
        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {
            curr.next = curr2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        netflix.LinkedListNode a = LinkedList.createLinkedList(new int[]{11, 41, 51});

        netflix.LinkedListNode b = LinkedList.createLinkedList(new int[]{21, 23, 42});

        netflix.LinkedListNode c = LinkedList.createLinkedList(new int[]{25, 56, 66, 72});

        List<netflix.LinkedListNode> list1 = new ArrayList<netflix.LinkedListNode>();
        list1.add(a);
        list1.add(b);
        list1.add(c);

        System.out.print("All movie ID's from best to worse are:\n");
        LinkedList.display(merge2County(a,c));
    }
}
