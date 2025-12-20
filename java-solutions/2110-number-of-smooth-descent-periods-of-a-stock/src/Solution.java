/**
 * @author sichu huang
 * @since 2025/12/15 16:47
 */
public class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = 1;
        int prev = 1;
        for (int i = 1; i < n; ++i) {
            if (prices[i] == prices[i - 1] - 1) {
                ++prev;
            } else {
                prev = 1;
            }
            res += prev;
        }
        return res;
    }
}
