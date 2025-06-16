package educative;

import java.sql.SQLOutput;

public class LinkedListPalindrome {
    public static boolean palindrome(LinkedListNode head) {
        // find middle
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half
        LinkedListNode prevHead = slow;
        LinkedListNode prev=null;
        LinkedListNode curr=slow;
        LinkedListNode next = null;
        while (curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr = next;
        }
        slow=head;

        while (prev != null) {
            if (prev.data != slow.data) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        slow = head;
        fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        prev = null;
        next = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        return true;

    }

    public static void main(String args[]) {

        int[][] input = {

                {5, 10, 15, 20, 15, 10, 5}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
