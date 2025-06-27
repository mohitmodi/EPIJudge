package exponent;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        // debug your code below
        LRUCache cache = new LRUCache(2);
        cache.putKey("user1", "Alex");
        cache.putKey("user2", "Alex2");
        cache.putKey("user1", "Alex33");
        System.out.println(cache.getKey("user1"));
    }

    class Node {
        String key;
        String value;
        Node prev;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int count;
    private Map<String, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.cache = new HashMap<>();
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;

    }

    String getKey(String key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }


    void putKey(String key, String value) {


        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            count++;
            addToHead(newNode);
        } else {
            node.value = value;
            cache.put(key, node);
            moveToHead(node);
        }

        if (count > capacity) {
            Node oldNode = removeTail();
            cache.remove(oldNode.key);
            count--;
        }

    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private void addToHead(Node newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = node.next;
        next.prev = node.prev;
    }
}
