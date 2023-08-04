/**
 * @author sichu
 * @date 2023/08/04
 **/
public class Solution {
    public int uniquePathsIII(int[][] grid) {
        int cnt = 0;
        int r = grid.length;
        int c = grid[0].length;
        int si = 0;
        int sj = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    ++cnt;
                } else if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                    ++cnt;
                }
            }
        }
        return dfs(grid, si, sj, cnt);
    }

    private int dfs(int[][] grid, int si, int sj, int cnt) {
        int r = grid.length;
        int c = grid[0].length;
        if (si < 0 || sj < 0 || si > r - 1 || sj > c - 1 || grid[si][sj] < 0) {
            return 0;
        }
        if (grid[si][sj] == 2) {
            return cnt == 0 ? 1 : 0;
        }
        int res = 0;
        grid[si][sj] = -1;
        res += dfs(grid, si - 1, sj, cnt - 1);
        res += dfs(grid, si + 1, sj, cnt - 1);
        res += dfs(grid, si, sj - 1, cnt - 1);
        res += dfs(grid, si, sj + 1, cnt - 1);
        grid[si][sj] = 0;
        return res;
    }
}
