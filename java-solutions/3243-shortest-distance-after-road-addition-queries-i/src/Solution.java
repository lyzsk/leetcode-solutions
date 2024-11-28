import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu huang
 * @since 2024/11/27 17:00
 */
public class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            neighbors.get(i).add(i + 1);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            neighbors.get(queries[i][0]).add(queries[i][1]);
            res[i] = bfs(n, neighbors);
        }
        return res;
    }

    private int bfs(int n, List<List<Integer>> neighbors) {
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = -1;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : neighbors.get(x)) {
                if (dist[y] >= 0) {
                    continue;
                }
                q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        return dist[n - 1];
    }
}
