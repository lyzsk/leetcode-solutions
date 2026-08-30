/**
 *
 * @author sichu huang
 * @since 2026/08/30 18:36
 */
public class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minidx = 0, maxidx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }
            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }
        int l = Math.min(minidx, maxidx);
        int r = Math.max(minidx, maxidx);
        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
    }
}
