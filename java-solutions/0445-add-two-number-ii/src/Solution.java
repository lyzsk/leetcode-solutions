import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/11/16
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.removeFirst();
            int num2 = stack2.isEmpty() ? 0 : stack2.removeFirst();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum %= 10;
            ListNode cur = new ListNode(sum);
            cur.next = res;
            res = cur;
        }
        return res;
    }
}
