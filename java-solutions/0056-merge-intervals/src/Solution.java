import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/09
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.isEmpty() || left > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
