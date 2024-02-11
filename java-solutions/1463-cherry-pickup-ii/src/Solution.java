import java.util.Arrays;

/**
 * @author sichu
 * @date 2024/02/11
 **/
public class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[x1][y1][x2][y2]表示机器人从(x1, y1)(x2, y2)出发到达底行的最大得分
        // 观察到 x1 == x2 始终成立，降维——dp[x][y1][y1]
        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int x = 1; x < m; x++) {
            for (int y1 = 0; y1 < n; y1++) {
                for (int y2 = n - 1; y2 >= y1; y2--) {
                    //上+上
                    dp[x][y1][y2] = dp[x - 1][y1][y2];
                    //左+左
                    if (y1 > 0) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1 - 1][y2 - 1]);
                    }
                    //右+右
                    if (y2 < n - 1) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1 + 1][y2 + 1]);
                    }
                    //左+右
                    if (y1 > 0 && y2 < n - 1) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1 - 1][y2 + 1]);
                    }
                    //右+左
                    if (y1 < n - 1 && y2 > 0) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1 + 1][y2 - 1]);
                    }
                    //上+左
                    if (y2 > 0) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1][y2 - 1]);
                    }
                    // 上+右
                    if (y2 < n - 1) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1][y2 + 1]);
                    }
                    //左+上
                    if (y1 > 0) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1 - 1][y2]);
                    }
                    //右+上
                    if (y1 < n - 1) {
                        dp[x][y1][y2] = Math.max(dp[x][y1][y2], dp[x - 1][y1 + 1][y2]);
                    }
                    if (y1 == y2) {
                        dp[x][y1][y2] += grid[x][y1];
                    } else {
                        dp[x][y1][y2] += (grid[x][y1] + grid[x][y2]);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[m - 1][i][j]);
            }
        }
        return res;
    }
}
