import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/12/31 15:13
 */
public class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> ls = new ArrayList<>();
        int n = obstacles.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int x = obstacles[i];
            int l = 0, r = ls.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (ls.get(mid) <= x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (l == ls.size()) {
                ls.add(x);
            } else {
                ls.set(l, x);
            }
            res[i] = l + 1;
        }
        return res;
    }
}
