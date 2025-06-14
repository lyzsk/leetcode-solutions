import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/06/13 14:36
 */
public class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 0; i < nums.length - 1; ) {
                if (nums[i + 1] - nums[i] <= mid) {
                    count++;
                    i += 2;
                } else {
                    i++;
                }
            }
            if (count >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
