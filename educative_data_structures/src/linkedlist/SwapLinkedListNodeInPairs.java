package linkedlist;


public class SwapLinkedListNodeInPairs {
    class Node {
        public int data;
        public Node next;

    }

    //'a' -> 'b' -> 'c' -> 'd' -> 'e' -> 'f' -> X
//'b' -> 'a' -> 'd' -> 'c' -> 'f' -> 'e' -> X
    public Node swapInPairs(Node head) {
        Node first = head;
        Node second = head.next;
        Node third = null;

        head = head.next;
        while (true) {
            third = second.next;
            second.next = first;
            if (third == null || third.next == null) {
                first.next = third;
                return head;
            }
            first.next=third.next;
            first=third;
            second=third.next;
        }
    }
}
