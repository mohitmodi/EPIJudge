package linkedlist;

import java.util.HashSet;

public class SinglyLinkedList < T > {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    //head node of the linked list
    public Node headNode;
    public int size;

    //constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public boolean isEmpty() {

        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        //iterate to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //make newNode the next element of the last node
        last.nextNode = newNode;
        size++;
    }

    //inserts data after the given prev data node
    public void insertAfter(T data, T previous) {

        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        //Start from head node
        Node currentNode = this.headNode;
        //traverse the list until node having data equal to previous is found
        while (currentNode != null && currentNode.data != previous) {
            currentNode = currentNode.nextNode;
        }
        //if such a node was found
        //then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    //Searches a value in the given list.
    public boolean searchNode(T data) {
        //Start from first element
        Node currentNode = this.headNode;

        //Traverse the list till you reach end
        while (currentNode != null) {
            if (currentNode.data.equals(data))
                return true; //value found

            currentNode = currentNode.nextNode;
        }
        return false; //value not found
    }

    //Deletes data from the head of list
    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteByValue(SinglyLinkedList < T > lst, T data) {
        // if empty then simply return
        if (lst.isEmpty())
            return;

        // Start from head node
        SinglyLinkedList < T > .Node currentNode = lst.headNode;
        SinglyLinkedList < T > .Node prevNode = null; // previous node starts from null

        if (currentNode.data.equals(data)) {
            // data is at the head, so delete from the head
            lst.deleteAtHead();
            return;
        }

        // traverse the list searching for the data to delete
        while (currentNode != null) {
            // node to delete is found
            if (data.equals(currentNode.data)) {
                prevNode.nextNode = currentNode.nextNode;
                lst.size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    public static <T> int length(SinglyLinkedList <T> list) {
        SinglyLinkedList < T > .Node currentNode = list.headNode;
        int length = 0;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.nextNode;
        }

        return length;
    }

    public static < T > Object findMiddle(SinglyLinkedList < T > list) {
        //if list is empty, then return null
        if (list.isEmpty())
            return null;

        //both nodes start from the head
        SinglyLinkedList<T>.Node mid = list.headNode;
        SinglyLinkedList<T>.Node current = list.headNode;

        while (mid != null && current != null && current.nextNode != null) {
            //current jumps 2 nodes on each iteration
            current = current.nextNode.nextNode;
            //if current is not null (end of list is not reached)
            if (current != null) {
                //then mid jumps 1 node
                //mid is always halfway behind current
                mid = mid.nextNode;
            }
        }
        return mid.data;
    }

    public static < V > SinglyLinkedList < V > removeDuplicatesWithHashing(SinglyLinkedList < V > list) {
        SinglyLinkedList < V > .Node current = list.getHeadNode();
        SinglyLinkedList < V > .Node prevNode = list.getHeadNode();
        //will store all the elements that we observe once
        HashSet < V > visitedNodes = new HashSet< V >();

        if (!list.isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
        return list;
    }

    public static < T > SinglyLinkedList < T > union(SinglyLinkedList < T > list1, SinglyLinkedList < T > list2) {

        //if one of the list is empty then return the other list
        if (list1.isEmpty())
            return list2;
        if (list2.isEmpty())
            return list1;

        //take the head of the first list
        SinglyLinkedList < T > .Node last = list1.headNode;
        //traverse it to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //attach the last element of list1 to head of list2
        last.nextNode = list2.headNode;
        //remove duplicates that might have been added now
        list1.removeDuplicatesWithHashing(); //complexity of this function is O(n)

        return list1;
    }

    public static < T > boolean contains(SinglyLinkedList < T > list, T data) {
        SinglyLinkedList < T > .Node current = list.headNode;
        while (current != null) {
            if (current.data.equals(data))
                return true;
            current = current.nextNode;
        }
        return false;
    }

    public static < T > SinglyLinkedList < T > intersection(SinglyLinkedList < T > list1, SinglyLinkedList < T > list2) {
        SinglyLinkedList < T > result = new SinglyLinkedList < T > ();
        if (list1.isEmpty())
            return result;
        if (list2.isEmpty())
            return result;
        SinglyLinkedList < T > .Node current = list1.headNode;

        while (current != null) {
            if (contains(list2, current.data)) {
                result.insertAtHead(current.data);
            }
            current = current.nextNode;
        }
        result.removeDuplicatesWithHashing();
        return result;
    }


}
