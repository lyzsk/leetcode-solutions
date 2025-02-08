/**
 * @author sichu huang
 * @since 2025/02/03 12:35
 */
public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        int incLen = 1;
        int decre = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decre = 1;
            } else if (nums[i] < nums[i - 1]) {
                decre++;
                incLen = 1;
            } else {
                incLen = 1;
                decre = 1;
            }
            res = Math.max(res, Math.max(incLen, decre));
        }
        return res;
    }
}
