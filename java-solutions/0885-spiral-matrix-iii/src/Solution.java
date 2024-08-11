/**
 * @author sichu huang
 * @date 2024/08/08
 **/
public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[] dr = new int[] {0, 1, 0, -1};
        int[] dc = new int[] {1, 0, -1, 0};
        int[][] res = new int[rows * cols][2];
        int t = 0;
        res[t++] = new int[] {rStart, cStart};
        if (rows * cols == 1) {
            return res;
        }
        for (int k = 1; k < 2 * (rows + cols); k += 2) {
            for (int i = 0; i < 4; ++i) {
                int dk = k + (i / 2);
                for (int j = 0; j < dk; ++j) {
                    rStart += dr[i];
                    cStart += dc[i];
                    if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
                        res[t++] = new int[] {rStart, cStart};
                        if (t == rows * cols) {
                            return res;
                        }
                    }
                }
            }
        }
        throw null;
    }
}
