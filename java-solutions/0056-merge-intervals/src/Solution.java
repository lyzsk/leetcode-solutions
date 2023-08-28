import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/09
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (res.isEmpty() || left > res.get(res.size() - 1)[1]) {
                res.add(new int[] {left, right});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
