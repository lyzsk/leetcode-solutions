import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/10/05
 **/
public class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int[] dp = new int[amount + 1];
    //     Arrays.fill(dp, Integer.MAX_VALUE);
    //     dp[0] = 0;
    //     for (int coin : coins) {
    //         for (int i = coin; i <= amount; i++) {
    //             if (dp[i - coin] != Integer.MAX_VALUE) {
    //                 dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    //             }
    //         }
    //     }
    //     return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    // }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
