/**
 * @author sichu huang
 * @since 2026/02/04 17:04
 */
public class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            long res = 0;
            while (j < n && nums[j - 1] < nums[j]) {
                j++;
            }
            int p = j - 1;
            if (p == i) {
                continue;
            }
            res += nums[p] + nums[p - 1];
            while (j < n && nums[j - 1] > nums[j]) {
                res += nums[j];
                j++;
            }
            int q = j - 1;
            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
                i = q;
                continue;
            }
            res += nums[q + 1];
            long maxSum = 0;
            long sum = 0;
            for (int k = q + 2; k < n && nums[k] > nums[k - 1]; k++) {
                sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;
            maxSum = 0;
            sum = 0;
            for (int k = p - 2; k >= i; k--) {
                sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;
            ans = Math.max(ans, res);
            i = q - 1;
        }
        return ans;
    }
}
