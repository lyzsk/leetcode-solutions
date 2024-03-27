/**
 * @author sichu huang
 * @date 2024/03/27
 **/
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int multi = 1;
        int res = 0;
        while (right < nums.length) {
            multi *= nums[right];
            while (multi >= k && left <= right) {
                multi /= nums[left];
                ++left;
            }
            res += right - left + 1;
            ++right;
        }
        return res;
    }
}
