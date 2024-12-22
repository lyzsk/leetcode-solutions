import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2024/12/21 17:37
 */
public class Solution {
    int components = 0;
    int n;
    int[] values;
    int k;
    List<Integer>[] adjacentArr;
    List<Integer>[] childrenArr;
    boolean[] visited;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.n = n;
        this.values = values;
        this.k = k;
        this.childrenArr = new List[n];
        this.adjacentArr = new List[n];
        for (int i = 0; i < n; i++) {
            childrenArr[i] = new ArrayList<>();
            adjacentArr[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjacentArr[edge[0]].add(edge[1]);
            adjacentArr[edge[1]].add(edge[0]);
        }
        this.visited = new boolean[n];
        visited[0] = true;
        dfs(0);
        subtreeSum(0);
        return components;
    }

    private void dfs(int node) {
        visited[node] = true;
        for (int next : adjacentArr[node]) {
            if (!visited[next]) {
                childrenArr[node].add(next);
                dfs(next);
            }
        }
    }

    private long subtreeSum(int node) {
        long sum = values[node];
        List<Integer> children = childrenArr[node];
        for (int child : children) {
            sum += subtreeSum(child);
        }
        if (sum % k == 0) {
            components++;
        }
        return sum;
    }
}
