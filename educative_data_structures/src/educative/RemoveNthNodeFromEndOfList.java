package educative;


public class RemoveNthNodeFromEndOfList {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode slowPointer = head;
        LinkedListNode fastPointer = head;
        while (n > 0) {
            fastPointer = fastPointer.next;
            n--;
        }
        if (fastPointer == null) {
            return head.next;
        }
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }


        LinkedListNode nodePrevious = slowPointer;
        LinkedListNode nodeNext = null;
        if (nodePrevious.next != null)
            nodeNext = nodePrevious.next.next;

        nodePrevious.next = nodeNext;
        return head;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {69,8,49,106,116,112}
        };

        int[] n = {5};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.printListWithForwardArrow(removeNthNodeFromLast(inputLinkedList.head, n[i]));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static LinkedListNode removeNthNodeFromLast(LinkedListNode head, int n) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        for (int i = 0; i < n-1; i++) {
            fast = fast.next;
        }
        if (fast.next == null) {
            return head.next;
        }
        LinkedListNode prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
    }
}


