/**
 *
 * @author sichu huang
 * @since 2026/09/04
 */
public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            min[n - i - 1] = Math.min(nums[n - i - 1], min[n - i]);
        }
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            int num = max - min[i];
            if (num <= k)
                return i;
        }
        return -1;
    }
}
