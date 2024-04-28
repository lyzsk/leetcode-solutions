import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/04/28
 **/
public class Solution {
    int[] res;
    int[] size;
    int[] dp;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        res = new int[n];
        size = new int[n];
        dp = new int[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int u, int f) {
        size[u] = 1;
        dp[u] = 0;
        for (int v : graph.get(u)) {
            if (v == f) {
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + size[v];
            size[u] += size[v];
        }
    }

    public void dfs2(int u, int f) {
        res[u] = dp[u];
        for (int v : graph.get(u)) {
            if (v == f) {
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = size[u], sv = size[v];

            dp[u] -= dp[v] + size[v];
            size[u] -= size[v];
            dp[v] += dp[u] + size[u];
            size[v] += size[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            size[u] = su;
            size[v] = sv;
        }
    }
}