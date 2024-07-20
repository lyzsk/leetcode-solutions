import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/07/19
 **/
public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isMin = true;
                boolean isMax = true;
                for (int k = 0; k < m; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        isMax = false;
                        break;
                    }
                }
                if (!isMin) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (matrix[k][j] > matrix[i][j]) {
                        isMax = false;
                        break;
                    }
                }
                if (isMax) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}