package educative;

public class SwapLinkedListNodeKFromBeginningKFromEnd {
    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode front = null;
        LinkedListNode back = null;
        int count = 0;
        int begin = k;
        while (k > 0) {
            if (count == begin - 1) {
                front = fast;
            }
            fast = fast.next;
            count++;

            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        back = slow;
        int temp = back.data;
        back.data = front.data;
        front.data = temp;
        return head;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5, 6, 7},
                {6, 9, 3, 10, 7, 4, 6},
                {6, 9, 3, 4},
                {6, 2, 3, 6, 9},
                {6, 2}
        };
        int[] k = {
                2, 3, 2, 3, 1
        };

        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list is: ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.println("\tk: " + k[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.printListWithForwardArrow(swapNodes1(list.head, k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static LinkedListNode swapNodes1(LinkedListNode head, int k) {
        //4 → 2 → 7 → 8 → 9 → 0 → 2
        //k=3
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode firstKthNode = head;
        LinkedListNode lastKthNode = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
            firstKthNode = firstKthNode.next;

        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        lastKthNode = slow;

        int temp = firstKthNode.data;
        firstKthNode.data = lastKthNode.data;
        lastKthNode.data = temp;

        return head;
    }
}
