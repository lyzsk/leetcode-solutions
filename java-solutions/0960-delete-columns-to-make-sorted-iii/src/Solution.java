import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/12/22 23:42
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 2; i >= 0; --i) {
            search:
            for (int j = i + 1; j < len; ++j) {
                for (String row : strs) {
                    if (row.charAt(i) > row.charAt(j)) {
                        continue search;
                    }
                }
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int kept = 0;
        for (int x : dp) {
            kept = Math.max(kept, x);
        }
        return len - kept;
    }
}
