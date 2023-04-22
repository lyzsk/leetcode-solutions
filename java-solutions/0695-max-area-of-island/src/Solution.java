/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int res = 1;
        res += dfs(grid, x - 1, y);
        res += dfs(grid, x + 1, y);
        res += dfs(grid, x, y - 1);
        res += dfs(grid, x, y + 1);
        return res;
    }
}
