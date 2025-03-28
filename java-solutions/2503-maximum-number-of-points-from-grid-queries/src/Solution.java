import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sichu huang
 * @since 2025/03/28 20:05
 */
public class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int[][] queriesIndices = new int[k][2];
        for (int i = 0; i < k; i++) {
            queriesIndices[i][0] = queries[i];
            queriesIndices[i][1] = i;
        }
        Arrays.sort(queriesIndices, Comparator.comparingInt(o -> o[0]));
        int[] answer = new int[k];
        int points = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        minheap.offer(new int[] {0, 0, grid[0][0]});
        for (int i = 0; i < k; i++) {
            int threshold = queriesIndices[i][0], index = queriesIndices[i][1];
            while (!minheap.isEmpty() && minheap.peek()[2] < threshold) {
                points++;
                int[] arr = minheap.poll();
                int row = arr[0], col = arr[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        minheap.offer(new int[] {newRow, newCol, grid[newRow][newCol]});
                    }
                }
            }
            answer[index] = points;
        }
        return answer;
    }
}
