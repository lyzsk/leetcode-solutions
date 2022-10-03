/**
 * @author sichu
 * @date 2022/10/03
 **/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
        // ListNode cur = head;
        // while (cur.next != null) {
        //     if (cur.val == cur.next.val) {
        //         cur.next = cur.next.next;
        //     } else {
        //         cur = cur.next;
        //     }
        // }
        // return head;
    }
}
