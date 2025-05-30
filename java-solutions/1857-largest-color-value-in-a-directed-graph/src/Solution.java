import java.util.*;

/**
 * @author sichu huang
 * @since 2025/05/26 08:43
 */
public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for (int[] edge : edges) {
            ++indeg[edge[1]];
            g.get(edge[0]).add(edge[1]);
        }
        int found = 0;
        int[][] f = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            ++found;
            int u = q.poll();
            ++f[u][colors.charAt(u) - 'a'];
            for (int v : g.get(u)) {
                --indeg[v];
                for (int c = 0; c < 26; ++c) {
                    f[v][c] = Math.max(f[v][c], f[u][c]);
                }
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (found != n) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, Arrays.stream(f[i]).max().getAsInt());
        }
        return res;
    }
}
