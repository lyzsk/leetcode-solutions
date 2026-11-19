import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/11/19
 */
public class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1]),
            nums[n - 1] - nums[2]);
    }
}
