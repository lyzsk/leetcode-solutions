import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/08/27
 **/
public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];
                if (dist[u] * prob > dist[v]) {
                    dist[v] = dist[u] * prob;
                    updated = true;
                }

                if (dist[v] * prob > dist[u]) {
                    dist[u] = dist[v] * prob;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return dist[end_node];
    }
}
