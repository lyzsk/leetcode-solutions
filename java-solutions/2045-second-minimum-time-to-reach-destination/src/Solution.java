import java.util.*;

/**
 * @author sichu huang
 * @date 2024/07/28
 **/
public class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[][] path = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        path[1][0] = 0;
        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] {1, 0});
        while (path[n][1] == Integer.MAX_VALUE) {
            int[] arr = queue.poll();
            int cur = arr[0], len = arr[1];
            for (int next : graph[cur]) {
                if (len + 1 < path[next][0]) {
                    path[next][0] = len + 1;
                    queue.offer(new int[] {next, len + 1});
                } else if (len + 1 > path[next][0] && len + 1 < path[next][1]) {
                    path[next][1] = len + 1;
                    queue.offer(new int[] {next, len + 1});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < path[n][1]; i++) {
            if (res % (2 * change) >= change) {
                res = res + (2 * change - res % (2 * change));
            }
            res = res + time;
        }
        return res;
    }
}
