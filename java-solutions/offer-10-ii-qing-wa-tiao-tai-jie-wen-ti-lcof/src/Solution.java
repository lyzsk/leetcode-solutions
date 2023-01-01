/**
 * @author sichu
 * @date 2023/01/01
 **/
public class Solution {
    public int numWays(int n) {
        final int MOD = (int)1e9 + 7;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}
