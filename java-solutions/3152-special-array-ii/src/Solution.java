import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/12/09 18:28
 */
public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (((nums[i] ^ nums[i - 1]) & 1) != 0) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            res[i] = dp[y] >= y - x + 1;
        }
        return res;
    }
}
