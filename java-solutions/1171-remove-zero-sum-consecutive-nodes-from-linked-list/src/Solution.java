import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/03/12
 **/
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy);
        while (head != null) {
            prefixSum += head.val;
            if (map.containsKey(prefixSum)) {
                ListNode start = map.get(prefixSum);
                ListNode temp = start;
                int sum = prefixSum;
                while (temp != head) {
                    temp = temp.next;
                    sum += temp.val;
                    if (temp != head) {
                        map.remove(sum);
                    }
                }
                start.next = head.next;
            } else {
                map.put(prefixSum, head);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
