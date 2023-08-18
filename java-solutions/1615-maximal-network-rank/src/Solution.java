/**
 * @author sichu
 * @date 2023/08/18
 **/
public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degrees = new int[n];
        int[][] connected = new int[n][n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            connected[x][y] = 1;
            connected[y][x] = 1;
            ++degrees[x];
            ++degrees[y];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degrees[i] + degrees[j] - connected[i][j];
                res = Math.max(res, rank);
            }
        }
        return res;
    }
}
