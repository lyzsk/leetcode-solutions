import java.util.List;

/**
 * @author sichu huang
 * @since 2025/09/26 00:40
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}
