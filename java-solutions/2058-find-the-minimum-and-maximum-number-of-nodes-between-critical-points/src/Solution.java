/**
 * @author sichu huang
 * @date 2024/07/05
 **/
public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        int firstIndex = 0;
        int preIndex = 0;
        int curIndex = 1;
        int min = Integer.MAX_VALUE;
        int max = -1;
        while (cur.next != null) {
            ListNode next = cur.next;
            boolean lt = pre.val > cur.val && cur.val < next.val;
            boolean gt = pre.val < cur.val && cur.val > next.val;
            if (lt || gt) {
                if (firstIndex == 0) {
                    firstIndex = curIndex;
                } else {
                    max = curIndex - firstIndex;
                    min = Math.min(min, curIndex - preIndex);
                }
                preIndex = curIndex;
            }
            ++curIndex;
            pre = cur;
            cur = cur.next;
        }
        return max == -1 ? new int[] {-1, -1} : new int[] {min, max};
    }
}
