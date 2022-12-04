/**
 * @author sichu
 * @date 2022/12/04
 **/
public class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int res = 0;
        int min = Integer.MAX_VALUE;
        long[] presum = new long[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int diff =
                (int)Math.abs(presum[i] / (i + 1) - ((n - i - 1 == 0) ? 0 : (presum[n - 1] - presum[i]) / (n - i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}
