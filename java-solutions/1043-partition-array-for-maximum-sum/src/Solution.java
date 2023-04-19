/**
 * @author sichu
 * @date 2023/04/19
 **/
public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                max = Math.max(max, arr[i]);
                dp[i] = max * (i + 1);
            } else {
                max = 0;
                for (int j = i; j > i - k; j--) {
                    max = Math.max(max, arr[j]);
                    dp[i] = Math.max(dp[i], dp[j - 1] + max * (i - j + 1));
                }
            }
        }
        return dp[n - 1];
    }
}
