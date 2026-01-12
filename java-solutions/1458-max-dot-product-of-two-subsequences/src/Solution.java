/**
 * @author sichu huang
 * @since 2026/01/08 15:57
 */
public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int neg = (int)-1e9;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = neg;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int take = nums1[i - 1] * nums2[j - 1] + Math.max(0, dp[i - 1][j - 1]);
                dp[i][j] = Math.max(take, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[n][m];
    }
}
