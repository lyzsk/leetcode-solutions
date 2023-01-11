import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/01/11
 **/
public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        if (!adj.containsKey(node)) {
            return 0;
        }
        int totalTime = 0;
        int childTime = 0;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            childTime = dfs(child, node, adj, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}
