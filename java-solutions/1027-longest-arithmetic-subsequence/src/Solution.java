import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/04/22
 **/
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int maxv = Arrays.stream(nums).max().getAsInt();
        int minv = Arrays.stream(nums).min().getAsInt();
        int diff = maxv - minv;
        int res = 1;
        for (int i = -diff; i <= diff; i++) {
            int[] dp = new int[maxv + 1];
            Arrays.fill(dp, -1);
            for (int num : nums) {
                int prev = num - i;
                if (prev >= minv && prev <= maxv && dp[prev] != -1) {
                    dp[num] = Math.max(dp[num], dp[prev] + 1);
                    res = Math.max(res, dp[num]);
                }
                dp[num] = Math.max(dp[num], 1);
            }
        }
        return res;
    }
}
