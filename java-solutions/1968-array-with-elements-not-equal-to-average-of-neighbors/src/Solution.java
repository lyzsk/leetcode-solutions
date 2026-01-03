/**
 * @author sichu huang
 * @since 2025/12/31 15:16
 */
public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i + 1] * 2 == nums[i] + nums[i + 2]) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (nums[i + 1] * 2 == nums[i] + nums[i + 2]) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (nums[i + 1] * 2 == nums[i] + nums[i + 2]) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
            }
        }
        return nums;
    }
}
