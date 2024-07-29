import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/07/27
 **/
public class Solution {
    private final long[][] dist = new long[26][26];

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE / 2);
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        floyd(dist);
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (dist[from][to] == Long.MAX_VALUE / 2) {
                return -1;
            }
            res += dist[from][to];
        }
        return res;
    }

    private void floyd(long[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
