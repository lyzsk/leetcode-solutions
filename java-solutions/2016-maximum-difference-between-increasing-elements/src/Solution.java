/**
 * @author sichu huang
 * @since 2025/06/17 01:55
 */
public class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int res = -1, premin = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > premin) {
                res = Math.max(res, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return res;
    }
}
