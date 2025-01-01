/**
 * @author sichu huang
 * @since 2024/12/30 19:50
 */
public class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        if (zero > one) {
            return countGoodStrings(low, high, one, zero);
        }

        int dp[] = new int[high + 1], res = 0;
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            int mod = (int)1e9 + 7;
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
            if (i >= low) {
                res = (res + dp[i]) % mod;
            }
        }

        return res;
    }
}
