/**
 * @author sichu
 * @date 2024/01/26
 **/
public class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = (int)(1e9 + 7);
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            int[][] dpNew = new int[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (dp[row][col] > 0) {
                        for (int[] dir : dirs) {
                            int row1 = row + dir[0];
                            int col1 = col + dir[1];
                            if (row1 >= 0 && row1 < m && col1 >= 0 && col1 < n) {
                                dpNew[row1][col1] = (dpNew[row1][col1] + dp[row][col]) % MOD;
                            } else {
                                res = (res + dp[row][col]) % MOD;
                            }
                        }
                    }
                }
            }
            dp = dpNew;
        }
        return res;
    }
}
