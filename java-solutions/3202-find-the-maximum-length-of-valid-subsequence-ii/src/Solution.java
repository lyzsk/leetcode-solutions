/**
 * @author sichu huang
 * @since 2025/07/18 00:53
 */
public class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}
