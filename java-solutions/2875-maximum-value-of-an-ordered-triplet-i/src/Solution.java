/**
 * @author sichu
 * @date 2023/10/01
 **/
public class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < n * 2; right++) {
            sum += nums[right % n];
            while (sum > target % total) {
                sum -= nums[left++ % n];
            }
            if (sum == target % total) {
                res = Math.min(res, right - left + 1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : (int)(res + (target / total) * n);
    }
}
