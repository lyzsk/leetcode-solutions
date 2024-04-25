/**
 * @author sichu huang
 * @date 2024/04/25
 **/
public class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            for (int j = 0; j <= k; j++) {
                int t1 = cur - j;
                int t2 = cur + j;
                if (t1 >= 0 && t1 < 26) {
                    dp[cur] = Math.max(dp[cur], dp[t1]);
                }
                if (t2 >= 0 && t2 < 26) {
                    dp[cur] = Math.max(dp[cur], dp[t2]);
                }
            }
            ++dp[cur];
            res = Math.max(res, dp[cur]);
        }
        return res;
    }
}
