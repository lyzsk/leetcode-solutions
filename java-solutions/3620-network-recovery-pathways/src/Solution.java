import java.util.*;

/**
 *
 * @author sichu huang
 * @since 2026/07/03 18:46
 */
public class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (!online[u] || !online[v]) {
                continue;
            }
            g.get(u).add(new int[] {v, w});
            l = Math.min(l, w);
            r = Math.max(r, w);
        }

        if (!check(g, l, k, n)) {
            return -1;
        }

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(g, mid, k, n)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(List<List<int[]>> g, int mid, long k, int n) {
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

        dis[0] = 0;
        pq.offer(new long[] {0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int)top[1];

            if (d > k) {
                return false;
            }
            if (u == n - 1) {
                return true;
            }
            if (d > dis[u]) {
                continue;
            }

            for (int[] edge : g.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (w < mid) {
                    continue;
                }
                if (dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    pq.offer(new long[] {dis[v], v});
                }
            }
        }
        return false;
    }
}
