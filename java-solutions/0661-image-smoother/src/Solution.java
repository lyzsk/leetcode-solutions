/**
 * @author sichu
 * @date 2023/12/19
 **/
public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = smoothen(img, i, j);
            }
        }
        return res;
    }

    private int smoothen(int[][] img, int x, int y) {
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int cnt = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                sum += img[nx][ny];
                ++cnt;
            }
        }
        return sum / cnt;
    }
}
