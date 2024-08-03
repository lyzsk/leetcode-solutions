/**
 * @author sichu huang
 * @date 2024/08/02
 **/
public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ++k;
            }
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = Math.min(res, k - sum);
        for (int i = 1; i < n; i++) {
            sum += nums[(i + k - 1) % n] - nums[i - 1];
            res = Math.min(res, k - sum);
        }
        return res;
    }
}
