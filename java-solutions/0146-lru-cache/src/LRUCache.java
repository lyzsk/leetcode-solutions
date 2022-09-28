import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * @author sichu
 * @date 2022/08/16
 **/
public class LRUCache {
    private final int capacity;
    private final DoublyLinkedListNode dummyHead;
    private final DoublyLinkedListNode dummyTail;
    private final Map<Integer, DoublyLinkedListNode> cache;
    private int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>(16);
        this.dummyHead = new DoublyLinkedListNode();
        this.dummyTail = new DoublyLinkedListNode();
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        DoublyLinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node = cache.get(key);
        if (node == null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            ++size;
            if (size > capacity) {
                DoublyLinkedListNode tail = dummyTail.prev;
                cache.remove(tail.key);
                removeNode(tail);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DoublyLinkedListNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoublyLinkedListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private static class DoublyLinkedListNode {
        private int key;
        private int value;
        private DoublyLinkedListNode prev;
        private DoublyLinkedListNode next;

        public DoublyLinkedListNode() {

        }

        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
