/**
 * @author sichu huang
 * @since 2025/01/21 18:36
 */
public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] p = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            p[0][i] = p[0][i - 1] + grid[0][i - 1];
            p[1][i] = p[1][i - 1] + grid[1][i - 1];
        }
        long res = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(p[0][n] - p[0][i], p[1][i - 1]));
        }
        return res;
    }
}
