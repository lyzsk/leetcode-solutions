/**
 * @author sichu
 * @date 2023/08/06
 **/
public class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        final int MOD = (int)(1e9 + 7);
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                long cnt1 = dp[i - 1][j - 1] * (n - j + 1);
                long cnt2 = dp[i - 1][j] * Math.max(j - k, 0);
                dp[i][j] = (cnt1 + cnt2) % MOD;
            }
        }
        return (int)dp[goal][n];
    }
}
