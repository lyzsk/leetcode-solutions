/**
 * @author sichu huang
 * @since 2025/08/13 01:14
 */
public class Solution {

    public int numberOfWays(int n, int x) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = (int)Math.pow(i, x);
            if (val > n) {
                break;
            }
            for (int j = n; j >= val; j--) {
                int MOD = (int)(1e9 + 7);
                dp[j] = (dp[j] + dp[j - val]) % MOD;
            }
        }
        return (int)dp[n];
    }
}
