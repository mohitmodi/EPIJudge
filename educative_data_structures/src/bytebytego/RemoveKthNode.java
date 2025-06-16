package bytebytego;

import educative.LinkedListNode;
import educative.PrintList;

public class RemoveKthNode {
    public static void main(String[] args) {
        bytebytego.LinkedList linkedList = new bytebytego.LinkedList();
        int[] list = new int[]{1};
        linkedList.createLinkedList(list);
        LinkedListNode reverse = remove(linkedList.head, 1);
        PrintList.printListWithForwardArrow(reverse);
    }

    private static LinkedListNode remove(LinkedListNode head, int k) {
        if (head == null) {
            return head;
        }
        LinkedListNode slow = null;
        LinkedListNode fast = head;
        while (k > 0 ) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next;
        }
        if (slow == null ) {
            return head.next;
        }
        if ( slow.next != null) {
            slow.next = slow.next.next;
        }

        return head;
    }
}
