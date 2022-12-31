/**
 * @author sichu
 * @date 2022/12/31
 **/
public class Solution {
    public int fib(int n) {
        final int MOD = (int)1e9 + 7;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}
