import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu
 * @date 2023/01/05
 **/
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        int pos = points[0][1];
        int res = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                ++res;
                pos = balloon[1];
            }
        }
        return res;
    }
}
