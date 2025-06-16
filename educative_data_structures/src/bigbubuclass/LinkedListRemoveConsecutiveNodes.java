package bigbubuclass;

public class LinkedListRemoveConsecutiveNodes {
    //Given a linked list, remove all consecutive nodes that sum to zero. Print out the remaining nodes.
    //
    //For example, suppose you are given the input 3 -> 4 -> -7 -> 5 -> -6 -> 6.
    // In this case, you should first remove 3 -> 4 -> -7, then -6 -> 6, leaving only 5.
    public static void main(String[] args) {
        // start=head end=head
        //sum value 3+4+-7 = 0 res = end.next
        //linked list res res = dummyNode
        Node n = new Node(3);
        n.next = new Node(4);
        n.next.next = new Node(-7);
        n.next.next.next = new Node(5);
        n.next.next.next.next = new Node(-6);
        n.next.next.next.next.next = new Node(6);
        Node res = removeConsecutiveNodes(n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    static Node removeConsecutiveNodes(Node head) {
        Node result = new Node(Integer.MAX_VALUE);
        Node resultHead = result;
        Node start = head;
        int sum = 0;
        while (start != null) {
            sum = start.val;
            Node end = start.next;
            while (end != null) {
                sum += end.val;
                if (sum == 0) {
                    start = end.next;
                    break;
                }
                end = end.next;
            }
            if (sum != 0) {
                result.next = new Node(start.val);
                result = result.next;
                start = start.next;
            }

        }
        return resultHead.next;
    }


}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}