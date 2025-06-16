package bigbubuclass;

import educative.LinkedListNode;

public class MergeAlternatingLL {
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(3);
        head1.next.next.next = new LinkedListNode(4);

        LinkedListNode head2 = new LinkedListNode(8);
        LinkedListNode linkedListNode = merge2Lists(head1, head2);
        while (linkedListNode != null) {
            System.out.println(linkedListNode.data);
            linkedListNode = linkedListNode.next;
        }
    }

    private static LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode curr = dummy;

        int counter = 1;
        while (head1 != null && head2 != null) {
            if (counter % 2 != 0) {
                curr.next = head1;
                head1 = head1.next;
                curr = curr.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
                curr = curr.next;
            }
            counter++;

        }
        if (head1 != null) {
            curr.next = head1;

        }
        if (head2 != null) {
            curr.next = head2;
        }
        return dummy.next;
    }
}
