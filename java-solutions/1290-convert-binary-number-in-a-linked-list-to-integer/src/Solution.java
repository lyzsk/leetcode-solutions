/**
 * @author sichu huang
 * @since 2025/07/15 00:30
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int res = 0;
        while (curNode != null) {
            res = res * 2 + curNode.val;
            curNode = curNode.next;
        }
        return res;
    }
}
