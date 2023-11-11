import java.util.*;

/**
 * @author sichu
 * @date 2023/11/11
 **/
public class Graph {
    private List<List<int[]>> adjacencyList;

    public Graph(int n, int[][] edges) {
        this.adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int[] edgeArray = {edge[1], edge[2]};
        adjacencyList.get(edge[0]).add(edgeArray);
    }

    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2);
    }

    private int dijkstra(int start, int end) {
        int n = adjacencyList.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[] {0, start});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curNode = cur[1];
            if (curNode == end) {
                return curCost;
            }
            for (int[] edge : adjacencyList.get(curNode)) {
                int neighbor = edge[0];
                int edgeLen = edge[1];
                int newRouteCost = edgeLen + distances[curNode];
                if (distances[neighbor] > newRouteCost) {
                    distances[neighbor] = newRouteCost;
                    pq.add(new int[] {newRouteCost, neighbor});
                }
            }
        }
        return distances[end] == Integer.MAX_VALUE ? -1 : distances[end];
    }
}
