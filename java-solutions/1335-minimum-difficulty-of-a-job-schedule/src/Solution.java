import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/05/16
 **/
public class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        final int INF = 1 << 30;
        int n = jobDifficulty.length;
        int[][] dp = new int[n + 1][d + 1];
        for (int[] x : dp) {
            Arrays.fill(x, INF);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(d, i); ++j) {
                int mx = 0;
                for (int k = i; k > 0; --k) {
                    mx = Math.max(mx, jobDifficulty[k - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[k - 1][j - 1] + mx);
                }
            }
        }
        return dp[n][d] >= INF ? -1 : dp[n][d];
    }
}
