package educative;

public class SwapLinkNodeInPairs {
    //a->b->c->d->e->f->X
    //b->a->d->c->f->e->X

    public static LinkedListNode swapInPairs(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode slow=head;
        LinkedListNode fast=head.next;
        while(fast!=null){
            int temp=slow.data;
            slow.data=fast.data;
            fast.data=temp;
            if(fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next.next;
            }else{
                fast=null;
            }
        }
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

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list is: ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.println("\tk: "+k[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.printListWithForwardArrow(swapInPairs(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
