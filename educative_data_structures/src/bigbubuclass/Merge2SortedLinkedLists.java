package bigbubuclass;

import educative.LinkedList;
import educative.LinkedListNode;
import educative.PrintList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge2SortedLinkedLists {

    private static LinkedListNode merge2Lists(LinkedListNode first, LinkedListNode last) {
        LinkedListNode curr1 = first;
        LinkedListNode curr2 = last;

        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode curr = dummy;

        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            }
            if (curr1 != null) {
                curr.next = curr1;
            }
            if (curr2 != null) {
                curr.next = curr2;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(100);
        head1.next = new LinkedListNode(200);

        LinkedListNode head2 = new LinkedListNode(170);
        head2.next = new LinkedListNode(350);
        LinkedListNode linkedListNode = merge2Lists(head1, head2);
        while (linkedListNode != null) {
            System.out.println(linkedListNode.data);
            linkedListNode = linkedListNode.next;
        }

    }
}
