/**
 *
 * @author sichu huang
 * @since 2026/06/06 08:56
 */
public class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int leftSum = 0;
        for (int i = 0; i < n; ++i) {
            res[i] = leftSum;
            leftSum += nums[i];
        }

        int rightSum = 0;
        for (int i = n - 1; i >= 0; --i) {
            res[i] = Math.abs(res[i] - rightSum);
            rightSum += nums[i];
        }

        return res;
    }
}
