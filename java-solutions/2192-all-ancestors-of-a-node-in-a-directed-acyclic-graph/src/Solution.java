import java.util.*;

/**
 * @author sichu huang
 * @date 2024/06/29
 **/
public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int v : graph.get(u)) {
                --inDegree[v];
                ancestors.get(v).add(u);
                for (int ancestor : ancestors.get(u)) {
                    ancestors.get(v).add(ancestor);
                }
                if (inDegree[v] == 0) {
                    queue.addLast(v);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
