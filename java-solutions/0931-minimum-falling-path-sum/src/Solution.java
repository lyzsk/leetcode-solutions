/**
 * @author sichu
 * @date 2024/01/19
 **/
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int[][] dp = new int[n][n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int upperLeft = j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int upper = dp[i - 1][j];
                int upperRight = j + 1 < n ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(upperLeft, Math.min(upper, upperRight)) + matrix[i][j];
                if (i == n - 1) {
                    res = Math.min(res, dp[n - 1][j]);
                }
            }
        }
        return res;
    }
}
