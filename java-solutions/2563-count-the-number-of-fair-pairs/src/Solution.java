import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/11/13 15:24
 */
public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; ++j) {
            int r = lowerBound(nums, j, upper - nums[j] + 1);
            int l = lowerBound(nums, j, lower - nums[j]);
            res += r - l;
        }
        return res;
    }

    private int lowerBound(int[] nums, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        return right;
    }
}
