package educative;

public class MiddleOfLinkedList {
    public static LinkedListNode middle(LinkedListNode head) {
        if(head==null || head.next==null)
        return head;
        LinkedListNode slow=head;
        LinkedListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
