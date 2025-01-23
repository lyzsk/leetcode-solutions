import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/01/20 15:10
 */
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];
        for (int i = 0; i < arr.length; ++i) {
            int[] v = map.get(arr[i]);
            ++rowCnt[v[0]];
            if (rowCnt[v[0]] == m) {
                return i;
            }
            ++colCnt[v[1]];
            if (colCnt[v[1]] == n) {
                return i;
            }
        }
        return -1;
    }
}
