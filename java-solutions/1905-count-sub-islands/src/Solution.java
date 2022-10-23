/**
 * @author sichu
 * @date 2022/10/23
 **/
public class Solution {
    private boolean flag = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                    if (flag) {
                        ++cnt;
                    }
                    flag = true;
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x > grid2.length - 1 || y > grid2[0].length - 1 || grid2[x][y] == 0) {
            return;
        }
        if (grid1[x][y] == 0) {
            flag = false;
        }
        grid2[x][y] = 0;
        dfs(grid1, grid2, x - 1, y);
        dfs(grid1, grid2, x + 1, y);
        dfs(grid1, grid2, x, y - 1);
        dfs(grid1, grid2, x, y + 1);
    }
}
