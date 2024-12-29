/**
 * @author sichu huang
 * @since 2024/12/27 18:16
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0, mx = values[0];
        for (int j = 1; j < values.length; ++j) {
            res = Math.max(res, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return res;
    }
}
