/**
 * @author sichu
 * @date 2023/05/12
 **/
public class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int value = 0;
        for (int i = 0; i < n - 1; i++) {
            value += Math.abs(nums[i] - nums[i + 1]);
        }
        int maxv1 = 0;
        for (int i = 1; i < n - 1; i++) {
            maxv1 = Math.max(maxv1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            maxv1 = Math.max(maxv1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        int maxv2 = Integer.MIN_VALUE;
        int minv2 = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            maxv2 = Math.max(maxv2, Math.min(x, y));
            minv2 = Math.min(minv2, Math.max(x, y));
        }
        return value + Math.max(maxv1, 2 * (maxv2 - minv2));
    }
}
