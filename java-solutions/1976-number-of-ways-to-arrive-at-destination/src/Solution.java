import java.util.*;

/**
 * @author sichu huang
 * @since 2025/03/23 18:14
 */
public class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int x = road[0], y = road[1], t = road[2];
            e[x].add(new int[] {y, t});
            e[y].add(new int[] {x, t});
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<long[]> minheap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        minheap.offer(new long[] {0, 0});
        dis[0] = 0;
        ways[0] = 1;
        while (!minheap.isEmpty()) {
            long[] arr = minheap.poll();
            long t = arr[0];
            int u = (int)arr[1];
            if (t > dis[u]) {
                continue;
            }
            for (int[] next : e[u]) {
                int v = next[0], w = next[1];
                if (t + w < dis[v]) {
                    dis[v] = t + w;
                    ways[v] = ways[u];
                    minheap.offer(new long[] {t + w, v});
                } else if (t + w == dis[v]) {
                    ways[v] = (ways[u] + ways[v]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
