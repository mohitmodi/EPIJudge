package bytebytego;

import educative.LinkedListNode;

import java.util.Hashtable;

class Node {
    Node prev;
    Node next;
    int value;
    int key;

}

public class LRUCache {
    int capacity;
    int total;
    Hashtable<Integer, Node> table;
    Node head;
    Node tail;


    LRUCache(int capacity) {
        this.capacity = capacity;
        this.table = new Hashtable<>();
        this.head = new Node();
        this.tail = new Node();
        this.total = 0;


        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }


    void put(int key, int value) {
        Node node = table.get(key);
        if (node != null) {
            node.value = value;
            table.put(key, node);
            moveToHead(node);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            table.put(key, newNode);
            total++;
            if (total > capacity) {
                Node oldNode = removeFromTail();
                addToHead(newNode);
                table.remove(oldNode.key);
                total--;
            } else {
                addToHead(newNode);
            }
        }

    }

    private Node removeFromTail() {
        return null;
    }

    private void addToHead(Node node) {
      node.prev=head;

    }

    private void moveToHead(Node node) {
        //removeNode(node);
        addToHead(node);
    }

    Integer get(int key) {
        Node node = null;
        if (table.contains(key)) {
            node = table.get(key);
            moveToHead(node);
        }
        return node == null ? -1 : node.value;
    }
}
