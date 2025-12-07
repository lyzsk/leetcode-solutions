import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/12/06 22:07
 */
public class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = (long)1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        Deque<Integer> minheao = new ArrayDeque<>();
        Deque<Integer> maxheap = new ArrayDeque<>();
        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            while (!maxheap.isEmpty() && nums[maxheap.peekLast()] <= nums[i]) {
                maxheap.pollLast();
            }
            maxheap.offerLast(i);
            while (!minheao.isEmpty() && nums[minheao.peekLast()] >= nums[i]) {
                minheao.pollLast();
            }
            minheao.offerLast(i);
            while (!maxheap.isEmpty() && !minheao.isEmpty()
                && nums[maxheap.peekFirst()] - nums[minheao.peekFirst()] > k) {
                if (maxheap.peekFirst() == j) {
                    maxheap.pollFirst();
                }
                if (minheao.peekFirst() == j) {
                    minheao.pollFirst();
                }
                j++;
            }
            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }
        return (int)dp[n];
    }
}
