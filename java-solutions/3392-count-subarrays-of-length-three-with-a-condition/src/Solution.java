/**
 * @author sichu huang
 * @since 2025/04/27 10:48
 */
public class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length, res = 0;
        if (nums.length < 3) {
            return res;
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++res;
            }
        }
        return res;
    }
}
