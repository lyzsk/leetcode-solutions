import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2026/01/25 14:24
 */
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
