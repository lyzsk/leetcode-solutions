/**
 * @author sichu
 * @date 2022/11/27
 **/
public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] presum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = presum[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (presum[i] - presum[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
