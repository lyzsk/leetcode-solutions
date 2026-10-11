/**
 *
 * @author sichu huang
 * @since 2026/10/11 13:14
 */
public class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                res += nums[i - 1] * nums[i - 1];
                if (i * i != n) {
                    res += nums[n / i - 1] * nums[n / i - 1];
                }
            }
        }
        return res;
    }
}
