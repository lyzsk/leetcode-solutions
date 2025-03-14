import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2025/02/13 19:21
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        for (int num : nums) {
            minheap.add((long)num);
        }
        long x, y;
        while (minheap.peek() < k) {
            x = minheap.poll();
            if (!minheap.isEmpty()) {
                y = minheap.poll();
                minheap.add(x * 2 + y);
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
