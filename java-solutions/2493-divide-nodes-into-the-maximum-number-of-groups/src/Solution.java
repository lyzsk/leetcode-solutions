import java.util.*;

/**
 * @author sichu huang
 * @since 2025/01/30 16:01
 */
public class Solution {
    private List<Integer>[] g;
    private List<Integer> idx = new ArrayList<>();
    private int[] color, cnt;
    private int res, time;

    public int magnificentSets(int n, int[][] edges) {
        g = new ArrayList[n + 5];
        color = new int[n + 5];
        cnt = new int[n + 5];
        Arrays.setAll(g, val -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                idx.clear();
                if (!dfs(i, 1)) {
                    return -1;
                }
                int t = 0;
                for (int x : idx) {
                    t = Math.max(t, bfs(x));
                }
                res += t;
            }
        }
        return res;
    }

    private boolean dfs(int u, int c) {
        color[u] = c;
        idx.add(u);
        for (int v : g[u]) {
            if (color[v] == c || color[v] == 0 && !dfs(v, 3 - c)) {
                return false;
            }
        }
        return true;
    }

    private int bfs(int s) {
        int step = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(s);
        time++;
        cnt[s] = time;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            while (size-- > 0) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (cnt[v] < time) {
                        q.add(v);
                        cnt[v] = time;
                    }
                }
            }
        }
        return step;
    }
}
