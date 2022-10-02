import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(new Status(node.val, node));
            }
        }
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            Status status = pq.poll();
            tail.next = status.node;
            tail = tail.next;
            if (status.node.next != null) {
                pq.offer(new Status(status.node.next.val, status.node.next));
            }
        }
        return dummyHead.next;
    }

    private static class Status implements Comparable<Status> {
        private final int val;
        private final ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status status) {
            return this.val - status.val;
        }
    }
}
