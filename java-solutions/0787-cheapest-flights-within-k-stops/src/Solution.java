import java.util.Arrays;

/**
 * @author sichu
 * @date 2024/02/23
 **/
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int len = 100;
        int INF = 0x3f3f3f3f;
        int[] dist = new int[len];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int limit = 0; limit < k + 1; limit++) {
            int[] clone = dist.clone();
            for (int[] flight : flights) {
                int from = flight[0];
                int cost = flight[1];
                int to = flight[2];
                dist[cost] = Math.min(dist[cost], clone[from] + to);
            }
        }
        return dist[dst] > INF / 2 ? -1 : dist[dst];
    }
}
