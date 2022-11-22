import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i == 3) {
                dp[i] = 3;
            } else {
                int div = (int)Math.sqrt(i);
                for (int j = 1; j <= div; j++) {
                    if (i - j * j < 0) {
                        break;
                    }
                    if (i - j * j == 0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                    }
                }
            }
        }
        return dp[n];
    }
}
