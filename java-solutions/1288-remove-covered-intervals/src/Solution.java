import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/07/06
 */
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,
            (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int count = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }

        return count;
    }
}
