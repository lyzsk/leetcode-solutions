import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/04/23
 **/
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findLongestNode(0, parent, adj);
        int y = findLongestNode(x, parent, adj);
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            res.add(path.get(m / 2 - 1));
        }
        res.add(path.get(m / 2));
        return res;
    }

    private int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[u] = 0;
        dfs(u, dist, parent, adj);
        int maxdist = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxdist) {
                maxdist = dist[i];
                node = i;
            }
        }
        return node;
    }

    private void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
        for (Integer v : adj[u]) {
            if (dist[v] < 0) {
                dist[v] = dist[u] + 1;
                parent[v] = u;
                dfs(v, dist, parent, adj);
            }
        }
    }
}
