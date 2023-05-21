import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2023/05/21
 **/
public class Solution {
    int res = Integer.MAX_VALUE;

    public int shortestBridge(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int flag = 0;
        int[][] visited1 = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, visited1);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[] {i, j});
                }
            }
        }
        int[][] visited2 = new int[r][c];
        int distance = -1;
        while (deque.size() > 0) {
            int size = deque.size();
            while (size > 0) {
                bfs(deque, grid, distance, visited2);
                --size;
            }
            ++distance;
        }
        return res;
    }

    private void bfs(Deque<int[]> deque, int[][] grid, int distance, int[][] visited2) {
        int[] point = deque.poll();
        int x = point[0];
        int y = point[1];
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || visited2[x][y] == 1) {
            return;
        }
        visited2[x][y] = 1;
        if (grid[x][y] == 1) {
            res = Math.min(res, distance);
            return;
        } else {
            if (x < grid.length - 1) {
                deque.offer(new int[] {x + 1, y});
            }
            if (y < grid[0].length) {
                deque.offer(new int[] {x, y + 1});
            }
            if (x - 1 >= 0) {
                deque.offer(new int[] {x - 1, y});
            }
            if (y - 1 >= 0) {
                deque.offer(new int[] {x, y - 1});
            }
        }
    }

    private void dfs(int x, int y, int[][] grid, int[][] visited1) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == 0 || visited1[x][y] == 1) {
            return;
        }
        grid[x][y] = 2;
        visited1[x][y] = 1;
        dfs(x, y - 1, grid, visited1);
        dfs(x, y + 1, grid, visited1);
        dfs(x - 1, y, grid, visited1);
        dfs(x + 1, y, grid, visited1);
    }
}
