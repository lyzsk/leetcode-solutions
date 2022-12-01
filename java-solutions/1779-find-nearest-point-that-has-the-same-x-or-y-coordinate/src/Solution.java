/**
 * @author sichu
 * @date 2022/11/30
 **/
public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallestDistance = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            int pointX = points[i][0];
            int pointY = points[i][1];
            if (pointX == x || pointY == y) {
                int distance = Math.abs(pointX - x) + Math.abs(pointY - y);
                if (distance < smallestDistance) {
                    smallestDistance = distance;
                    res = i;
                }
            }
        }
        return res;
    }
}
