package bigbubuclass;

import educative.LinkedListNode;

public class ReverseLLINBetweenNodes {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        int left = 1;
        int right = 3;
        LinkedListNode newHead = reverse(head, left, right);
        LinkedListNode curr = newHead;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    private static LinkedListNode reverse(LinkedListNode head, int left, int right) {
        int i = 0;
        LinkedListNode leftPrev = null;
        LinkedListNode leftNode = null;
        LinkedListNode rightNext = null;
        LinkedListNode rightNode = null;
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode newCurr = dummy;
        LinkedListNode curr = head;
        while (i < left) {
            curr = curr.next;
            i++;
        }
        leftPrev = curr;
        leftNode = curr.next;
        int j = i;
        while (j < right) {
            curr = curr.next;
            j++;
        }
        rightNext = curr.next;
        rightNode = curr;


        return dummy.next;

    }

    private static LinkedListNode reverse(LinkedListNode left, LinkedListNode right) {
        return left;
    }
}
