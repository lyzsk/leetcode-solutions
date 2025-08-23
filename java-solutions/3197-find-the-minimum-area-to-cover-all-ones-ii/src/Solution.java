import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/08/23 11:15
 */
public class Solution {
    public int minimumSum(int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int rot = 0; rot < 4; rot++) {
            int n = grid.length, m = grid[0].length;
            for (int i = 1; i < n; i++) {
                int a1 = minimumArea(Arrays.copyOfRange(grid, 0, i));
                for (int j = 1; j < m; j++) {
                    int[][] part2 = new int[n - i][j];
                    int[][] part3 = new int[n - i][m - j];
                    for (int r = 0; r < n - i; r++) {
                        part2[r] = Arrays.copyOfRange(grid[i + r], 0, j);
                        part3[r] = Arrays.copyOfRange(grid[i + r], j, m);
                    }
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
                for (int i2 = i + 1; i2 < n; i2++) {
                    int[][] part2 = Arrays.copyOfRange(grid, i, i2);
                    int[][] part3 = Arrays.copyOfRange(grid, i2, n);
                    int a2 = minimumArea(part2);
                    int a3 = minimumArea(part3);
                    res = Math.min(res, a1 + a2 + a3);
                }
            }
            grid = rotate(grid);
        }
        return res;
    }

    private int minimumArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        int right = -1, bottom = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    left = Math.min(left, j);
                    top = Math.min(top, i);
                    right = Math.max(right, j);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        if (right == -1) {
            return 0;
        }
        return (right - left + 1) * (bottom - top + 1);
    }

    private int[][] rotate(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = grid[i][j];
            }
        }
        return rotated;
    }
}
