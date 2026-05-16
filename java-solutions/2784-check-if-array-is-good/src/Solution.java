import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/05/14 19:44
 */
public class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        return nums[n] == n;
    }
}
