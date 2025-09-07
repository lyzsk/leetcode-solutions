/**
 * @author sichu huang
 * @since 2025/08/24 23:20
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int p0 = 0, p1 = 0;
        for (int num : nums) {
            if (num == 0) {
                p1 = p0;
                p0 = 0;
            } else {
                ++p0;
                ++p1;
            }
            res = Math.max(res, p1);
        }
        if (res == nums.length) {
            --res;
        }
        return res;
    }
}
