/**
 *
 * @author sichu huang
 * @since 2026/10/25
 */
public class Solution {
    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i, j, grid, m, n)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean dfs(int x, int y, int[][] grid, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        if (grid[x][y] != 0) {
            return true;
        }
        grid[x][y] = -1;
        boolean ret1 = dfs(x - 1, y, grid, m, n);
        boolean ret2 = dfs(x + 1, y, grid, m, n);
        boolean ret3 = dfs(x, y - 1, grid, m, n);
        boolean ret4 = dfs(x, y + 1, grid, m, n);
        return ret1 && ret2 && ret3 && ret4;
    }
}
