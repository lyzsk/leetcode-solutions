/**
 * @author sichu huang
 * @since 2024/10/27 15:15
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m, n);
        boolean[][][] dp = new boolean[m][n][len];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = (matrix[i][j] == 1);
                count += dp[i][j][0] ? 1 : 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < len; k++) {
                    dp[i][j][k] =
                        (matrix[i][j] == 1 && dp[i - 1][j][k - 1] && dp[i][j - 1][k - 1] && dp[i
                            - 1][j - 1][k - 1]);
                    if (dp[i][j][k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
