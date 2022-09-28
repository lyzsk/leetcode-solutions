/**
 * @author sichu
 * @date 2022/08/18
 **/
public class Solution {
    private static ListNode reverseList(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        return slow;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null) {
            for (int i = 0; i < k && fast != null; i++) {
                fast = fast.next;
            }
            if (fast == null) {
                break;
            }
            ListNode start = slow.next;
            ListNode nextStart = fast.next;
            fast.next = null;
            slow.next = reverseList(start);
            start.next = nextStart;
            slow = start;
            fast = start;
        }
        return dummy.next;
    }
}
