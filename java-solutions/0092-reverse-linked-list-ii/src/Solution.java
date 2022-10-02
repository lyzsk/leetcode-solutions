/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode partOneTail = dummy;
        for (int i = 0; i < left - 1; i++) {
            partOneTail = partOneTail.next;
        }
        ListNode partTwoHead = partOneTail.next;
        ListNode partTwoTail = partTwoHead;
        for (int i = 0; i < right - left; i++) {
            partTwoTail = partTwoTail.next;
        }
        ListNode partThreeHead = partTwoTail.next;
        partTwoTail.next = null;
        partOneTail.next = reverseList(partTwoHead);
        partTwoHead.next = partThreeHead;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
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
