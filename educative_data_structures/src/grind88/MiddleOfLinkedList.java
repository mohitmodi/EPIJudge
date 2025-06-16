package grind88;

import educative.LinkedListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(100);
        head1.next = new LinkedListNode(200);
        head1.next.next = new LinkedListNode(170);
        head1.next.next.next = new LinkedListNode(350);
       // head1.next.next.next.next = new LinkedListNode(400);
        LinkedListNode linkedListNode = middle(head1);
        System.out.println(linkedListNode.data);

    }

    private static LinkedListNode middle(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
