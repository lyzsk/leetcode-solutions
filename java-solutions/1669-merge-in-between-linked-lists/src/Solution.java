/**
 * @author sichu huang
 * @date 2024/03/20
 **/
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curNode = list1;
        int idx = 0;
        while (idx < a - 1) {
            curNode = curNode.next;
            ++idx;
        }
        ListNode front = curNode;
        while (idx < b + 1) {
            curNode = curNode.next;
            ++idx;
        }
        ListNode rear = curNode;
        ListNode secondListHead = list2;
        ListNode secondListTail = list2;
        while (secondListTail.next != null) {
            secondListTail = secondListTail.next;
        }
        front.next = secondListHead;
        secondListTail.next = rear;
        return list1;
    }
}
