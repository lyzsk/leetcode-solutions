package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/11/28
 **/
public class Solution {
    private List<List<Integer>> edges;
    private int[] visited;
    private boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.edges = new ArrayList<>();
        this.visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequire : prerequisites) {
            edges.get(prerequire[1]).add(prerequire[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int v) {
        visited[v] = 1;
        for (int u : edges.get(v)) {
            if (visited[u] == 0) {
                dfs(u);
                if (!valid) {
                    return;
                }
            } else if (visited[u] == 1) {
                valid = false;
                return;
            }
        }
        visited[v] = 2;
    }
}
