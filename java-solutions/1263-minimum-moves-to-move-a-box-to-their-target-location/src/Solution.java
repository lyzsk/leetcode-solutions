import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sichu huang
 * @since 2026/01/12 15:56
 */
public class Solution {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int bx = -1, by = -1, px = -1, py = 0, tx = -1, ty = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
                if (grid[i][j] == 'S') {
                    px = i;
                    py = j;
                }
            }
        }
        int[][][][] memo = new int[m][n][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        memo[bx][by][px][py] = 0;

        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] {bx, by, px, py});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tx && cur[1] == ty) {
                return memo[cur[0]][cur[1]][cur[2]][cur[3]];
            }
            for (int[] dir : dirs) {
                int npx = cur[2] + dir[0], npy = cur[3] + dir[1];
                if (npx < 0 || npx >= m || npy < 0 || npy >= n) {
                    continue;
                }
                if (grid[npx][npy] == '#') {
                    continue;
                }
                if (npx == cur[0] && npy == cur[1]) {
                    continue;
                }
                if (memo[cur[0]][cur[1]][npx][npy] >= 0) {
                    continue;
                }
                queue.addFirst(new int[] {cur[0], cur[1], npx, npy});
                memo[cur[0]][cur[1]][npx][npy] = memo[cur[0]][cur[1]][cur[2]][cur[3]];
            }

            if (Math.abs(cur[0] - cur[2]) + Math.abs(cur[1] - cur[3]) == 1) {
                for (int[] dir : dirs) {
                    int npx = cur[2] + dir[0], npy = cur[3] + dir[1];
                    if (npx == cur[0] && npy == cur[1]) {
                        int nbx = cur[0] + dir[0], nby = cur[1] + dir[1];
                        if (nbx < 0 || nbx >= m || nby < 0 || nby >= n) {
                            continue;
                        }
                        if (grid[nbx][nby] == '#') {
                            continue;
                        }
                        if (memo[nbx][nby][cur[2]][cur[3]] >= 0) {
                            continue;
                        }
                        queue.addLast(new int[] {nbx, nby, cur[2], cur[3]});
                        memo[nbx][nby][cur[2]][cur[3]] = memo[cur[0]][cur[1]][cur[2]][cur[3]] + 1;
                    }
                }
            }
        }
        return -1;
    }
}