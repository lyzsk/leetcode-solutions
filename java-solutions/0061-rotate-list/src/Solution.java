/**
 * @author sichu
 * @date 2022/10/26
 **/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode itr = head;
        while (itr.next != null) {
            itr = itr.next;
            ++n;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        itr.next = head;
        while (add-- > 0) {
            itr = itr.next;
        }
        ListNode res = itr.next;
        itr.next = null;
        return res;
    }
}
