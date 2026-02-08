/**
 * @author sichu huang
 * @since 2026/02/03 18:28
 */
public class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (nums[0] >= nums[1]) {
            return false;
        }
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++;
            }
        }
        return count == 3;
    }
}
