import java.util.*;

/**
 * @author sichu huang
 * @since 2025/03/22 14:02
 */
public class Solution {
    private final Map<Integer, List<Integer>> graph = new HashMap<>();

    public int countCompleteComponents(int n, int[][] edges) {
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Set<Integer> component = new HashSet<>();
                dfs(i, component, visited);
                if (isCompleteComponent(component)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int node, Set<Integer> component, Set<Integer> visited) {
        component.add(node);
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, component, visited);
            }
        }
    }

    private boolean isCompleteComponent(Set<Integer> component) {
        for (int node : component) {
            if (graph.getOrDefault(node, new ArrayList<>()).size() != component.size() - 1) {
                return false;
            }
        }
        return true;
    }
}
