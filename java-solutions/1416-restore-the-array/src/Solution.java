/**
 * @author sichu
 * @date 2023/04/23
 **/
public class Solution {
    private final int MOD = (int)(1e9 + 7);

    public int numberOfArrays(String s, int k) {
        int n = s.length();
        long kl = k;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long num = 0;
            long base = 1;
            for (int j = i - 1; j >= 0 && i - j <= 10; j--) {
                num += (s.charAt(j) - '0') * base;
                if (num > kl) {
                    break;
                }
                if (s.charAt(j) != '0') {
                    dp[i] += dp[j];
                    dp[i] %= MOD;
                }
                base *= 10;
            }
        }
        return dp[n];
    }
}
