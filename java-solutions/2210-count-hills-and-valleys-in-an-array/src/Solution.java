/**
 * @author sichu huang
 * @since 2025/07/28 01:52
 */
public class Solution {
    public int countHillValley(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int left = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] > nums[i]) {
                    left = 1;
                    break;
                } else if (nums[j] < nums[i]) {
                    left = -1;
                    break;
                }
            }
            int right = 0;
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] > nums[i]) {
                    right = 1;
                    break;
                } else if (nums[j] < nums[i]) {
                    right = -1;
                    break;
                }
            }
            if (left == right && left != 0) {
                ++res;
            }
        }
        return res;
    }
}
