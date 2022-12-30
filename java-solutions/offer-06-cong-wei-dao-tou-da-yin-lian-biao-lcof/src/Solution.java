import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/12/30
 **/
public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addFirst(head);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.removeFirst().val;
        }
        return res;
    }
}
