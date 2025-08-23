/**
 * @author sichu huang
 * @since 2025/08/22 14:39
 */
public class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int minI = n, maxI = 0;
        int minJ = m, maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    minI = Math.min(minI, i);
                    maxI = Math.max(maxI, i);
                    minJ = Math.min(minJ, j);
                    maxJ = Math.max(maxJ, j);
                }
            }
        }
        return (maxI - minI + 1) * (maxJ - minJ + 1);
    }
}
