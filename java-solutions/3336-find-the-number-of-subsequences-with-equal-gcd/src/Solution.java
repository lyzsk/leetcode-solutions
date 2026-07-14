/**
 *
 * @author sichu huang
 * @since 2026/07/14
 */
public class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][201][201];
        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int g1 = 0; g1 <= 200; g1++) {
                for (int g2 = 0; g2 <= 200; g2++) {

                    if (dp[i][g1][g2] == 0)
                        continue;

                    long ways = dp[i][g1][g2];

                    dp[i + 1][g1][g2] = (int)((dp[i + 1][g1][g2] + ways) % MOD);

                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    dp[i + 1][ng1][g2] =
                        (int)((dp[i + 1][ng1][g2] + ways) % MOD);

                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    dp[i + 1][g1][ng2] =
                        (int)((dp[i + 1][g1][ng2] + ways) % MOD);
                }
            }
        }

        long res = 0;
        for (int g = 1; g <= 200; g++) {
            res = (res + dp[n][g][g]) % MOD;
        }

        return (int)res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
