/**
 * @author sichu huang
 * @since 2026/01/12 15:54
 */
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            res += Math.max(Math.abs(points[i][0] - points[i - 1][0]),
                Math.abs(points[i][1] - points[i - 1][1]));
        }
        return res;
    }
}
