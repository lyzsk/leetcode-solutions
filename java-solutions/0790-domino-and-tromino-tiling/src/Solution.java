/**
 * @author sichu
 * @date 2022/12/24
 **/
public class Solution {
    private final int MOD = (int)(1e9 + 7);

    public int numTilings(int n) {
        // 0: 没覆盖; 1: 上覆盖一个; 2: 下覆盖一个; 3: 上下覆盖两个
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }
}
