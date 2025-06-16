package educative;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode nextNode = null;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;

        }

        return prev;
    }

    public static LinkedListNode reverse2(LinkedListNode head) {
        // 1 -> 2 -> 3
        // 2->1
        // 3 ->2 -> 1
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode currNext = null;
        while (curr != null) {
            currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr = currNext;
        }
        return prev;

    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, -2, 3, 4, -5, 4, 3, -2, 1}
        };

        int[] n = {2};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.printListWithForwardArrow(reverse(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
