/**
 * TODO: 把值交换改成节点交换
 *
 * @author sichu
 * @date 2023/05/15
 **/
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = new ListNode();
        left.next = head;
        ListNode right = new ListNode();
        right.next = head;
        for (int i = 0; i < k; i++) {
            left = left.next;
        }
        ListNode cur = left;
        while (cur != null) {
            right = right.next;
            cur = cur.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}
