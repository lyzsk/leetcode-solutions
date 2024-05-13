/**
 * @author sichu huang
 * @date 2024/05/13
 **/
public class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = (1 << (m - 1)) * n;
        for (int j = 1; j < m; ++j) {
            int val = 1 << (m - 1 - j);
            int set = 0;
            for (int[] ints : grid) {
                if (ints[j] == ints[0]) {
                    set++;
                }
            }
            res += Math.max(set, n - set) * val;
        }
        return res;
    }
}
