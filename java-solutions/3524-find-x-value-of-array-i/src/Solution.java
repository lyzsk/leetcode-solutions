/**
 *
 * @author sichu huang
 * @since 2026/09/21
 */
public class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] ndp = new long[k];
            ndp[num % k]++;
            for (int r = 0; r < k; r++) {
                ndp[(int)(((long)r * num) % k)] += dp[r];
            }
            dp = ndp;
            for (int r = 0; r < k; r++) {
                res[r] += dp[r];
            }
        }

        return res;
    }
}
