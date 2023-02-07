/**
 * @author sichu
 * @date 2022/10/22
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode p2 = reverseList(firstHalfEnd.next);
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
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
}
