/**
 * @author sichu huang
 * @date 2024/05/14
 **/
public class Solution {
    private final int[] roww = {1, -1, 0, 0};
    private final int[] coll = {0, 0, -1, 1};
    private int maxGold = 0;

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j, n, m));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 0;
        }
        int curr = grid[x][y];
        grid[x][y] = 0;
        int localMaxGold = curr;
        for (int i = 0; i < 4; i++) {
            int newX = x + roww[i];
            int newY = y + coll[i];
            localMaxGold = Math.max(localMaxGold, curr + dfs(grid, newX, newY, n, m));
        }
        grid[x][y] = curr;
        return localMaxGold;
    }
}
