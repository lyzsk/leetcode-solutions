import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2025/01/18 09:21
 */
public class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[] {0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0], col = cell[1], cost = cell[2];
            if (costs[row][col] < cost) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int newRow = row + dir[0], newCol = col + dir[1];
                int newCost = cost + (grid[row][col] == i + 1 ? 0 : 1);
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && costs[newRow][newCol] > newCost) {
                    costs[newRow][newCol] = newCost;
                    pq.offer(new int[] {newRow, newCol, newCost});
                }
            }
        }
        return costs[m - 1][n - 1];
    }
}
