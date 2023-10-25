import java.util.ArrayList;

/**
 * @author sichu
 * @date 2023/10/21
 **/
public class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer>[] neighbors = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        long sum = 0;
        long squaresum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long res = dfs(i, neighbors, visited);
                sum += res;
                squaresum += res * res;
            }
        }
        return (sum * sum - squaresum) >> 1;
    }

    private long dfs(int node, ArrayList<Integer>[] neighbors, boolean[] visited) {
        visited[node] = true;
        int res = 1;
        for (int neighbor : neighbors[node]) {
            if (!visited[neighbor]) {
                res += dfs(neighbor, neighbors, visited);
            }
        }
        return res;
    }
}
