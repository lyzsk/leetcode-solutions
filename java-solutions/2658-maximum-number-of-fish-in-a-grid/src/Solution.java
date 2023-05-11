/**
 * @author sichu
 * @date 2023/05/11
 **/
public class Solution {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > 0) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] <= 0) {
            return 0;
        }
        int res = grid[x][y];
        grid[x][y] = 0;
        res += dfs(grid, x - 1, y);
        res += dfs(grid, x + 1, y);
        res += dfs(grid, x, y - 1);
        res += dfs(grid, x, y + 1);
        return res;
    }
}
