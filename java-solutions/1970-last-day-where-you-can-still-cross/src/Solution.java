import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/12/31 15:11
 */
public class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col, res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int[][] grid = new int[row][col];
            for (int i = 0; i < row; i++) {
                Arrays.fill(grid[i], 1);
            }
            for (int i = 0; i < mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 0;
            }
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < col; i++) {
                if (grid[0][i] == 1) {
                    q.offer(new int[] {0, i});
                    grid[0][i] = 0;
                }
            }
            boolean found = false;
            while (!q.isEmpty()) {
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                        if (nx == row - 1) {
                            found = true;
                            break;
                        }
                        q.offer(new int[] {nx, ny});
                        grid[nx][ny] = 0;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
