/**
 *
 * @author sichu huang
 * @since 2026/03/18 16:05
 */
public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid[0].length;
        int[] cols = new int[m];
        int res = 0;
        for (int[] x : grid) {
            int rows = 0;
            for (int j = 0; j < m; j++) {
                cols[j] += x[j];
                rows += cols[j];
                if (rows <= k) {
                    res++;
                }
            }
        }
        return res;
    }
}
