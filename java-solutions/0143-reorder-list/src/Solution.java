/**
 * @author sichu
 * @date 2022/10/03
 **/
public class Solution {
    private static ListNode middleNode(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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

    private static void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
        }
    }

    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode l2Start = mid.next;
        mid.next = null;
        ListNode l1 = head;
        ListNode l2 = reverseList(l2Start);
        mergeList(l1, l2);
    }
}
