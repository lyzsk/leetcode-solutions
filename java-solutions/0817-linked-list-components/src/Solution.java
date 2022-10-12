import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/10/12
 **/
public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    ++res;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }
}
