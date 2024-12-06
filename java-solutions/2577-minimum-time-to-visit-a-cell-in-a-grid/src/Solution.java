import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2024/11/29 18:14
 */
public class Solution {
    private static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        boolean[][] seen = new boolean[rows][cols];
        minheap.offer(new int[] {0, 0, 0});
        seen[0][0] = true;
        while (!minheap.isEmpty()) {
            int[] curr = minheap.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];
            for (int[] dir : MOVES) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols
                    || seen[newRow][newCol]) {
                    continue;
                }
                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }
                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }
                seen[newRow][newCol] = true;
                minheap.offer(new int[] {newTime, newRow, newCol});
            }
        }
        return -1;
    }
}
