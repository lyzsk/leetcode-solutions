import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/11/26
 **/
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    res.add(new int[] {left, right});
                    placed = true;
                }
                res.add(interval);
            } else if (interval[1] < left) {
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            res.add(new int[] {left, right});
        }
        return res.toArray(new int[res.size()][2]);
    }
}
