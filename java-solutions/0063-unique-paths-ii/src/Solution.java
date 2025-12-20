/**
 * @author sichu huang
 * @since 2025/12/20 14:43
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] o : obstacleGrid) {
            for (int j = 0; j < n; ++j) {
                if (o[j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && o[j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[n - 1];
    }
}
