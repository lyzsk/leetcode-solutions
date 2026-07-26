import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/07/26 16:45
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
