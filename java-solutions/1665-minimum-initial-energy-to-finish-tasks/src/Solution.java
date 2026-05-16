import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/05/12 19:02
 */
public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));
        int res = 0;
        for (int[] task : tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}
