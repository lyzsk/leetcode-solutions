import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/01/22 17:11
 */
public class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(res[i], -1);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (0 <= x && x < m && 0 <= y && y < n && res[x][y] == -1) {
                    res[x][y] = res[p[0]][p[1]] + 1;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return res;
    }
}
