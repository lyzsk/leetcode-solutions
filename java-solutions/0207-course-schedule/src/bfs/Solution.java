package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sichu
 * @date 2022/11/28
 **/
public class Solution {
    private List<List<Integer>> edges;
    private int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.edges = new ArrayList<>();
        this.indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequire : prerequisites) {
            edges.get(prerequire[1]).add(prerequire[0]);
            ++indegree[prerequire[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int v = queue.poll();
            for (int u : edges.get(v)) {
                --indegree[u];
                if (indegree[u] == 0) {
                    queue.offer(u);
                }
            }
        }
        return visited == numCourses;
    }
}
