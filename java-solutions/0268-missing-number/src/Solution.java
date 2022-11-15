/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            res ^= i;
        }
        return res;
    }
}
