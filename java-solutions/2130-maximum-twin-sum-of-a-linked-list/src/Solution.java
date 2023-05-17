/**
 * @author sichu
 * @date 2023/05/17
 **/
public class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = null;
        ListNode last = slow.next;
        while (last != null) {
            ListNode temp = last.next;
            last.next = first;
            first = last;
            last = temp;
        }
        slow.next = first;
        int res = 0;
        ListNode x = head;
        ListNode y = slow.next;
        while (y != null) {
            res = Math.max(res, x.val + y.val);
            x = x.next;
            y = y.next;
        }
        return res;
    }
}
