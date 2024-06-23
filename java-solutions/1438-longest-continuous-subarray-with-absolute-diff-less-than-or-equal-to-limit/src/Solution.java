import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @date 2024/06/23
 **/
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);
            minQueue.offerLast(nums[right]);
            while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (nums[left] == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                if (nums[left] == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                ++left;
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }
}
