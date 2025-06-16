package educative;

public class ReverseNodesInEvenLength {
    //1 2 3 4 5 6
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {
        int gn = 1;
        LinkedListNode curr = null;
        LinkedListNode prev = head;
        int numOfNodes = 0;
        while (prev.next != null) {
            curr = prev;
            gn++;
            for (int i = 0; i < gn; i++) {

                if (curr.next == null) {
                    break;
                }
                numOfNodes++;
                curr = curr.next;
            }
            if (gn % 2 == 0 || (numOfNodes % 2 == 0 && numOfNodes != 0)) {
                LinkedListNode previous = null;
                LinkedListNode headOfGroup = prev.next;
                LinkedListNode current = headOfGroup;
                LinkedListNode nextNode = current.next;
                LinkedListNode prevHead = prev;
                while (current != null && numOfNodes > 0) {
                    nextNode = current.next;
                    current.next = previous;
                    previous = current;
                    current = nextNode;
                    numOfNodes--;
                }
                headOfGroup.next = nextNode;
                prevHead.next = previous;
                prev = headOfGroup;

            }else{
                prev=curr;
            }
            numOfNodes = 0;
        }
        return head;
    }

    static void reverse(LinkedListNode prev, LinkedListNode headOfGroup, int n) {


    }


    public static void main(String[] args) {
        int[][] inputs = {
                {11,12,13,14,15},

        };

        int[] n = {2};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.printListWithForwardArrow(reverseEvenLengthGroups(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
