/**
 * @author sichu
 * @date 2023/08/24
 **/
public class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rowCnt = new int[r];
        int[] colCnt = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    ++rowCnt[i];
                    ++colCnt[j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1)) {
                    ++res;
                }
            }
        }
        return res;
    }
}
