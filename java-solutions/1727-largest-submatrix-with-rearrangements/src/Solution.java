import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/11/26
 **/
public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = n - 1; j >= 0; j--) {
                int height = matrix[i][j];
                res = Math.max(res, height * (n - j));
            }
        }
        return res;
    }
}
