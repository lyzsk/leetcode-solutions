/**
 * @author sichu huang
 * @since 2025/12/02 00:12
 */
public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int cap : batteries) {
            sum += cap;
        }
        long left = 0, right = sum / n, res = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long total = 0;
            for (int cap : batteries) {
                total += Math.min(cap, mid);
            }
            if (total >= n * mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
