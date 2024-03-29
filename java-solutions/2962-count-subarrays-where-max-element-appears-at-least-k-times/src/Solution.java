/**
 * @author sichu huang
 * @date 2024/03/29
 **/
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxNum = Long.MIN_VALUE;
        int count = 0;
        int left = 0;
        int right = 0;
        long res = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        while (right < nums.length || left > right) {
            if (nums[right] == maxNum) {
                ++count;
            }
            while (count >= k) {
                if (nums[left] == maxNum) {
                    --count;
                }
                ++left;
                res += nums.length - right;
            }
            ++right;
        }
        return res;
    }
}
