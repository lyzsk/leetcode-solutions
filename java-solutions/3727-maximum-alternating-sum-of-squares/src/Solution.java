import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/10/13
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < n / 2; i++) {
            res -= nums[i];
        }
        for (int i = n / 2; i < n; i++) {
            res += nums[i];
        }
        return res;
    }
}
