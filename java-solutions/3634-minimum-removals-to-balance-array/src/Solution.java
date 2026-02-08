import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2026/02/06 16:16
 */
public class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = n;
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long)nums[left] * k) {
                right++;
            }
            res = Math.min(res, n - (right - left));
        }
        return res;
    }
}
