/**
 * @author sichu huang
 * @since 2026/01/19 08:39
 */
public class Solution {

    private int rows, cols;

    public int maxSideLength(int[][] mat, int threshold) {
        rows = mat.length;
        cols = mat[0].length;
        int[][] prefix = new int[rows + 1][cols + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                prefix[r][c] =
                    prefix[r - 1][c] + prefix[r][c - 1] - prefix[r - 1][c - 1] + mat[r - 1][c - 1];
            }
        }
        int left = 0;
        int right = Math.min(rows, cols);
        int res = 0;
        while (left <= right) {
            int size = left + (right - left) / 2;
            if (existsValidSquare(prefix, size, threshold)) {
                res = size;
                left = size + 1;
            } else {
                right = size - 1;
            }
        }
        return res;
    }

    private boolean existsValidSquare(int[][] prefix, int size, int limit) {
        for (int r = size; r <= rows; r++) {
            for (int c = size; c <= cols; c++) {
                int squareSum =
                    prefix[r][c] - prefix[r - size][c] - prefix[r][c - size] + prefix[r - size][c
                        - size];
                if (squareSum <= limit) {
                    return true;
                }
            }
        }
        return false;
    }
}
