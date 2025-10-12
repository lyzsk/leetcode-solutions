/**
 * @author sichu huang
 * @since 2025/10/06 22:39
 */
public class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int n;

    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        int left = 0;
        int right = n * n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[n][n];
            if (grid[0][0] <= mid && dfs(grid, 0, 0, visited, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int threshold) {
        visited[x][y] = true;
        for (int[] direction : dirs) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                if (newX == n - 1 && newY == n - 1) {
                    return true;
                }

                if (dfs(grid, newX, newY, visited, threshold)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
