/**
 *
 * @author sichu huang
 * @since 2026/03/04 18:17
 */
public class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int cnt1 = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cnt1++;
                }
            }
            if (i == 0) {
                cnt1--;
            }
            if (cnt1 > 0) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        mat[0][j] += cnt1;
                    }
                }
            }
        }
        int sum = 0;
        for (int num : mat[0]) {
            if (num == 1) {
                sum++;
            }
        }
        return sum;
    }
}
