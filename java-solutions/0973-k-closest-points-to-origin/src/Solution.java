import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/27
 **/
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (point1, point2) -> {
            return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
        });
        return Arrays.copyOfRange(points, 0, k);
    }
}
