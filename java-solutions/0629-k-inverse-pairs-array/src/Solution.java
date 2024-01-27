/**
 * @author sichu
 * @date 2024/01/27
 **/
public class Solution {
    public int kInversePairs(int n, int k) {
        final int MOD = (int)(1e9 + 7);
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int prefixSum = 0;
            for (int j = 0; j <= k; j++) {
                prefixSum = (prefixSum + dp[i - 1][j]) % MOD;
                if (j >= i) {
                    prefixSum = (prefixSum - dp[i - 1][j - i] + MOD) % MOD;
                }
                dp[i][j] = (dp[i][j] + prefixSum) % MOD;
            }
        }

        return dp[n][k];
    }
}
