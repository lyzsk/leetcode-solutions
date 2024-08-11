/**
 * @author sichu huang
 * @date 2024/08/11
 **/
public class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (count(grid, n, m) != 1) {
            return 0;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) {
                    grid[i][j] = 0;
                    if (count(grid, n, m) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int count(int[][] grid, int n, int m) {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    cnt++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return cnt;
    }

    private void dfs(int x, int y, int[][] grid, int n, int m) {
        grid[x][y] = 2;
        for (int i = 0; i < 4; ++i) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] != 1) {
                continue;
            }
            dfs(tx, ty, grid, n, m);
        }
    }
}
