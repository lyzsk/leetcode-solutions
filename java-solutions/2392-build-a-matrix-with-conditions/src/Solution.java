import java.util.*;

/**
 * @author sichu huang
 * @date 2024/07/21
 **/
public class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 在行方向进行 k 个数字的拓扑排序
        // row 数组记录行下标的分配情况
        int[] row = new int[k + 1];
        // 记录入度
        int[] indegree = new int[k + 1];
        // 构建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : rowConditions) {
            graph.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 从 0 开始分配下标
        int current = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            row[u] = current++;
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        // current - 1 是当前分配了下标的数字数目，如果和参与拓扑排序的数字个数不同，就说明分配失败（有环），返回空矩阵
        if (current != k) {
            return new int[0][0];
        }
        // 在列方向进行 k 个数字的拓扑排序，和行方向上的处理方式一致
        int[] col = new int[k + 1];
        graph.clear();
        Arrays.fill(indegree, 0);
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : colConditions) {
            graph.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        queue.clear();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        current = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            col[u] = current++;
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (current != k) {
            return new int[0][0];
        }
        // 根据行方向和列方向上的下标分配关系填充矩阵
        int[][] res = new int[k][k];
        for (int i = 1; i <= k; i++) {
            res[row[i]][col[i]] = i;
        }
        return res;
    }
}
