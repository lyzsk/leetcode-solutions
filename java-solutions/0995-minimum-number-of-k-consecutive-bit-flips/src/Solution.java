import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @date 2024/06/24
 **/
public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() > 0 && i > queue.peek() + k - 1) {
                queue.removeFirst();
            }
            if (queue.size() % 2 == nums[i]) {
                if (i + k > nums.length) {
                    return -1;
                }
                queue.addLast(i);
                res += 1;
            }
        }
        return res;
    }
}
