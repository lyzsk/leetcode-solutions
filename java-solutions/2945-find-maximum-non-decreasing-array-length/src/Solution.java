import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2026/01/15 16:30
 */
public class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 2], dp = new int[n + 1];
        long[] acc = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            acc[i] = acc[i - 1] + nums[i - 1];
        }
        for (int i = 0, j = 1; j <= n; j++) {
            i = Math.max(i, pre[j]);
            dp[j] = dp[i] + 1;
            int k = Arrays.binarySearch(acc, 2 * acc[j] - acc[i]);
            if (k < 0) {
                k = -k - 1;
            }
            pre[k] = j;
        }
        return dp[n];
    }
}
