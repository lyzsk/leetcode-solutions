/**
 * @author sichu
 * @date 2022/09/28
 **/
public class Solution {
    public boolean hasCycle(ListNode head) {
        //        if (head == null || head.next == null) {
        //            return false;
        //        }
        //        ListNode slow = head;
        //        ListNode fast = head.next;
        //        while (slow != fast) {
        //            if (fast == null || fast.next == null) {
        //                return false;
        //            }
        //            slow = slow.next;
        //            fast = fast.next.next;
        //        }
        //        return true;
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
