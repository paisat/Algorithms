package ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 23/10/15.
 */
public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.get(2);
        cache.set(2, 6);
        cache.get(1);
        cache.set(1, 5);
        cache.set(1, 2);
        cache.get(1);
        cache.get(2);


    }

    private class Node {

        private int key;
        private int value;
        private Node right;
        private Node left;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node end;

    private int capacity;

    private Map<Integer, Node> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<Integer, Node>();
    }

    public int get(int key) {

        if (hashMap.get(key) != null) {

            Node node = hashMap.get(key);
            remove(node);
            setHead(node);

            return node.value;
        }

        return -1;
    }

    private void remove(Node node) {

        if (node == head) {
            head = node.right;
        }

        if (node == end) {
            end = node.left;
        }

        if (node != head && node != end) {

            Node prev = node.left;
            Node next = node.right;
            prev.right = next;
            next.left = prev;

        }
    }

    private void setHead(Node node) {

        if (head == null) {
            head = node;
            end = head;

        } else {

            node.right = head;
            head.left = node;
            head = node;
        }

    }

    public void set(int key, int value) {

        if (hashMap.get(key) == null) {

            Node node = new Node(key, value);
            if (hashMap.size() >= capacity) {
                int lruKey = end.key;
                remove(end);

                hashMap.remove(lruKey);
                hashMap.put(key, node);
                setHead(node);
            } else {
                hashMap.put(key, node);
                setHead(node);
            }
        } else {

            Node node = hashMap.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        }

    }

}
