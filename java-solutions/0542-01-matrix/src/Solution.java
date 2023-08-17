import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sichu
 * @date 2023/08/17
 **/
public class Solution {
    private static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; i++) {
                int dx = x + dirs[i][0];
                int dy = y + dirs[i][1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visited[dx][dy]) {
                    res[dx][dy] = res[x][y] + 1;
                    queue.offer(new int[] {dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }
        return res;
    }
}
