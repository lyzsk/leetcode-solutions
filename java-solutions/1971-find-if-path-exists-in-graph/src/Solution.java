import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/04/21
 **/
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    public boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int next : adj[source]) {
            if (!visited[next] && dfs(next, destination, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
