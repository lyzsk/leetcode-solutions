import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/12/07
 **/
public class Solution {
    public int minAreaRect(int[][] points) {
        // 定义一个矩阵只要左下角+右上角, 然后判断剩下两点是否在points中
        // 因为 0<=y<=40000, state = x * 40001 + y 可以唯一确定一个(x, y)
        // x = state / 40001, y = state % 40001
        if (points.length < 4) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] * 40001 + point[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                int need1 = x1 * 40001 + y2;
                int need2 = x2 * 40001 + y1;
                if (set.contains(need1) && set.contains(need2)) {
                    res = Math.min(res, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
