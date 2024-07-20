/**
 * @author sichu huang
 * @date 2024/07/20
 **/
public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] res = new int[n][m];
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int v = Math.min(rowSum[i], colSum[j]);
            res[i][j] = v;
            rowSum[i] -= v;
            colSum[j] -= v;
            if (rowSum[i] == 0) {
                ++i;
            }
            if (colSum[j] == 0) {
                ++j;
            }
        }
        return res;
    }
}
