/**
 * * Your MyCircularDeque object will be instantiated and called as such:
 * * MyCircularDeque obj = new MyCircularDeque(k);
 * * boolean param_1 = obj.insertFront(value);
 * * boolean param_2 = obj.insertLast(value);
 * * boolean param_3 = obj.deleteFront();
 * * boolean param_4 = obj.deleteLast();
 * * int param_5 = obj.getFront();
 * * int param_6 = obj.getRear();
 * * boolean param_7 = obj.isEmpty();
 * * boolean param_8 = obj.isFull();
 *
 * @author sichu
 * @date 2022/08/15
 **/
public class MyCircularDeque {

    private static int capacity;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int size;

    public MyCircularDeque(int k) {
        capacity = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(value);
        if (size == 0) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(value);
        if (size == 0) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        ++size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = head.next;
        --size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = tail.prev;
        --size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private static class DoublyLinkedListNode {
        private final int val;
        private DoublyLinkedListNode prev;
        private DoublyLinkedListNode next;

        public DoublyLinkedListNode(int val) {
            this.val = val;
        }
    }
}